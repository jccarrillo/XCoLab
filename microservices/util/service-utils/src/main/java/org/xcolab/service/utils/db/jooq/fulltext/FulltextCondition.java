package org.xcolab.service.utils.db.jooq.fulltext;

import org.jooq.Context;
import org.jooq.Field;
import org.jooq.impl.CustomCondition;

public class FulltextCondition extends CustomCondition {

    private final String query;
    private final FulltextSearchModifier searchModifier;
    private final Field<?>[] fields;

    public FulltextCondition(String query, Field<?>... fields) {
        this(query, FulltextSearchModifier.NONE, fields);
    }

    public FulltextCondition(String query, FulltextSearchModifier searchModifier, Field<?>... fields) {
        super();
        this.query = query;
        this.searchModifier = searchModifier;
        this.fields = fields;
    }

    public Field<Double> as(String alias) {
        return new FulltextField(alias, this).as(alias);
    }

    @Override
    public void accept(Context<?> context) {
        switch (context.configuration().dialect().family()) {
            case MYSQL:
                context.sql("MATCH (");
                boolean isFirst = true;
                for (Field<?> field : fields) {
                    if (isFirst) {
                        context.visit(field);
                        isFirst = false;
                    } else {
                        context.sql(", ").visit(field);
                    }
                }
                context.sql(") AGAINST ('");
                context.literal(query);
                if (searchModifier != FulltextSearchModifier.NONE) {
                    context.sql(" " + searchModifier.name());
                }
                context.sql("')");
                break;
            default:
                throw new UnsupportedOperationException("Dialect not supported");
        }
    }
}
