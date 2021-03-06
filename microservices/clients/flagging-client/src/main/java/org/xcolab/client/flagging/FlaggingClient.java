package org.xcolab.client.flagging;

import org.springframework.core.ParameterizedTypeReference;

import org.xcolab.client.flagging.exceptions.ReportNotFoundException;
import org.xcolab.client.flagging.exceptions.ReportTargetNotFoundException;
import org.xcolab.client.flagging.pojo.AggregatedReport;
import org.xcolab.client.flagging.pojo.Report;
import org.xcolab.client.flagging.pojo.ReportTarget;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.util.enums.flagging.ManagerAction;
import org.xcolab.util.enums.flagging.TargetType;
import org.xcolab.util.http.RequestUtils;
import org.xcolab.util.http.UriBuilder;
import org.xcolab.util.http.client.RestResource;
import org.xcolab.util.http.client.RestService;
import org.xcolab.util.http.exceptions.EntityNotFoundException;

import java.util.List;

public final class FlaggingClient {

    private static final RestService flaggingService = new RestService("flagging-service");
    private static final RestResource<Report> reportResource = new RestResource<>(flaggingService,
            "reports", Report.TYPES);
    private static final RestResource<AggregatedReport> aggregatedReportResource = new RestResource<>(
            flaggingService, "aggregatedReports", AggregatedReport.TYPES);
    private static final RestResource<ReportTarget> reportTargetResource = new RestResource<>(
            flaggingService, "reportTargets", ReportTarget.TYPES);

    private FlaggingClient() {
    }

    public static List<Report> listReports(int start, int last) {
        return listReports(start, last, null, null, null, null, null);
    }

    public static List<Report> listReports(int start, int last, Long reporterMemberId,
            TargetType targetType, Long targetId, Long targetAdditionalId, Long managerMemberId) {

        return reportResource.list()
                .addRange(start, last)
                .queryParam("sort", "createDate")
                .optionalQueryParam("reporterMemberId", reporterMemberId)
                .optionalQueryParam("targetType", targetType)
                .optionalQueryParam("targetId", targetId)
                .optionalQueryParam("targetAdditionalId", targetAdditionalId)
                .optionalQueryParam("managerMemberId", managerMemberId)
                .execute();
    }

    public static int countReports(Long reporterMemberId, TargetType targetType, Long targetId,
            Long targetAdditionalId, Long managerMemberId) {
        return reportResource.count()
                .optionalQueryParam("reporterMemberId", reporterMemberId)
                .optionalQueryParam("targetType", targetType)
                .optionalQueryParam("targetId", targetId)
                .optionalQueryParam("targetAdditionalId", targetAdditionalId)
                .optionalQueryParam("managerMemberId", managerMemberId)
                .execute();
    }

    public static List<AggregatedReport> listAggregatedReports(int start, int last) {
        return aggregatedReportResource.list()
                .addRange(start, last)
                .queryParam("managerAction", ManagerAction.PENDING)
                .queryParam("sort", "firstReportDate")
                .execute();
    }

    public static Report getReport(long reportId) throws ReportNotFoundException {
        try {
            return reportResource.get(reportId).cacheIdentifier("reportId_" + reportId).execute();
        } catch (EntityNotFoundException e) {
            throw new ReportNotFoundException(reportId);
        }
    }

    public static boolean updateReport(Report report) {
        return reportResource.update(report, report.getReportId()).execute();
    }

    public static Report createReport(Report report) {
        return reportResource.create(report).execute();
    }

    public static List<ReportTarget> listReportTargets(int start, int last) {
        return listReportTargets(start, last, null);
    }

    public static List<ReportTarget> listReportTargets(TargetType targetType) {
        return listReportTargets(0, Integer.MAX_VALUE, targetType);
    }

    public static List<ReportTarget> listReportTargets(int start, int last, TargetType targetType) {
        return reportTargetResource.list()
                .addRange(start, last)
                .optionalQueryParam("type", targetType)
                .execute();
    }

    public static ReportTarget getReportTarget(long reportTargetId)
            throws ReportTargetNotFoundException {
        try {
            return reportTargetResource.get(reportTargetId)
                    .cacheIdentifier("id_" + reportTargetId)
                    .execute();
        } catch (EntityNotFoundException e) {
            throw new ReportTargetNotFoundException(reportTargetId);
        }
    }

    public static ReportTarget getReportTarget(TargetType type, String reason)
            throws ReportTargetNotFoundException {
        //TODO: port to new methods
        final UriBuilder uriBuilder = reportTargetResource.getResourceUrl()
                    .queryParam("type", type.name())
                    .queryParam("reason", reason);
        try {
            return RequestUtils.getFirstFromList(uriBuilder,
                    new ParameterizedTypeReference<List<ReportTarget>>() {
                    }, "type_" + type.name() + "reason_" + reason);
        } catch (EntityNotFoundException e) {
            throw new ReportTargetNotFoundException(type, reason);
        }
    }

    public static boolean updateReportTarget(ReportTarget reportTarget) {
        return reportTargetResource.update(reportTarget, reportTarget.getReportTargetId())
                .execute();
    }

    public static boolean deleteReportTarget(long reportTargetId) {
        return reportTargetResource.delete(reportTargetId).execute();
    }

    public static ReportTarget createReportTarget(ReportTarget reportTarget) {
        return reportTargetResource.create(reportTarget).execute();
    }

    public static Report reportProposal(Member reporter, long proposalId, long proposalVersion,
            String reason, String comment) {
        return report(reporter, proposalId, proposalVersion, TargetType.PROPOSAL, reason, comment);
    }

    public static Report reportComment(Member reporter, long commentId,
            String reason, String comment) {
        return report(reporter, commentId, 0L, TargetType.COMMENT, reason, comment);
    }

    public static Report report(Member reporter, long targetId, Long targetAdditionalId,
            TargetType targetType, String reason, String comment) {
        Report report = new Report();
        report.setReporterMemberId(reporter.getId_());
        report.setTargetType(targetType.name());
        report.setTargetId(targetId);
        report.setTargetAdditionalId(targetAdditionalId);
        report.setWeight(reporter.getReportKarma());
        report.setReason(reason);
        report.setComment(comment);
        report.setManagerAction(ManagerAction.PENDING.name());
        return createReport(report);
    }

    public static boolean handleReport(long managerId, ManagerAction managerAction, long reportId) {
        return reportResource.service(reportId, "handle", Boolean.class)
                .queryParam("managerMemberId", managerId)
                .queryParam("managerAction", managerAction)
                .post();
    }
}
