<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav fl">
            <li class="${navhome}"><a href="${ctx}/main.html">Home</a></li>
            <li class="${navdash}"><a href="${ctx}/dashboard.html">Dashboards</a></li>
          </ul>
	       <div class="logout-info">
	          <a class="btn btn-primary" data-toggle="collapse" 
						data-target="#collapseLogout">
					${user.userId }
			  </a>
			  <div id="collapseLogout" class="link-panel collapse">
					<a href="${ctx}/logout" >Logout</a>
			  </div>
			</div>
        </div><!--/.nav-collapse -->
      </div>
</nav>
