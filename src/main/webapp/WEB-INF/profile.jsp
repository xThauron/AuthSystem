<%@ include file="layout/header.jsp" %>

<div class="col-lg-6">
    <div class="row">
        <h1>Your profile:</h1>
    </div>
    <div class="row">
        <div class="col-sm-4">User ID:</div>
        <div class="col-sm-2"><% out.print(user.getId()); %></div>
    </div>
    <div class="row">
        <div class="col-sm-4">Username:</div>
        <div class="col-sm-2"><% out.print(user.getUsername()); %></div>
    </div>
    <div class="row">
        <div class="col-sm-4">Email:</div>
        <div class="col-sm-2"><% out.print(user.getEmail()); %></div>
    </div>
    <div class="row">
        <div class="col-sm-4">Role:</div>
        <div class="col-sm-2"><% out.print(user.getRole()); %></div>
    </div>
</div>
<%@ include file="layout/footer.jsp" %>