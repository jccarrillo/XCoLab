<div class="lrContentPlaceholder lfr-column ">
    $processor.processColumn("column-1")
</div>

<div id="c-Popup__suggest" >
    <div class="c-Popup__wrapper p1" id="suggestContestPopup">
        <div class="c-Popup">
            <h4>Please enter your suggestion below.  A message will be sent to the CoLab staff and they will follow up with you soon.</h4>
            <div id="suggestContestPopupContent" class="lrContentPlaceholder lfr-column ">
                $processor.processColumn("column-4")
            </div>
        </div>
    </div>
</div>
        
<div id="c-Footer">
    <div id="c-Footer__menu">
        <ul>
            <li><a href="/web/guest/feedback">Contact</a></li>
            <li><a href="/web/guest/resources/-/wiki/Main/Help">Help</a></li>
            #if ($themeDisplay.signedIn)
                <li><a href="/c/portal/logout">Sign out</a></li>
                <li><a href="/web/guest/member/-/member/userId/$themeDisplay.user.userId">My profile</a></li>
            #else 
                <li><a href="/web/guest/loginregister" class="openreg">Register</a></li>
                <li><a href="javascript:return false;" onclick="deferUntilLogin();">Sign In</a></li>
            #end
        </ul>
    </div> <!-- #c-Footer__menu -->
    
    <div class="inner lrContentPlaceholder lfr-column ">
                $processor.processColumn("column-2")
    </div> <!-- .inner -->
</div> <!-- #c-Footer -->
