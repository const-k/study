<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel-height { height: 370px; }
</style>
<div class="col-lg-12">

	<!-- search area -->
	<div class="row" style="margin-top : 50px; margin-bottom : 50px;">
		<div class="form-group">
			<div class="col-sm-12">
				<input type="text" class="form-control" placeholder="검색어 입력">
			</div>
		</div>
	</div>
	<!-- // search area -->
	
	<div class="row mt">
		<!-- free board area -->
		<div class="col-md-6 mb">
			<div class="grey-panel pn panel-height">
				<div class="grey-header">
					<h5>자유 게시판</h5>
				</div>
				<div class="col-md-12">
					<section class="task-panel tasks-widget">
					<div class="task-content">
						<ul id="sortable" class="task-list sortable-ui">
							<li class="list-primary">
							<i class=" fa fa-ellipsis-v"></i>
							<div class="task-title">
								<span class="task-title-sp"><a href="#">Dashgum - Admin Panel Theme</a></span>
								<span class="badge bg-theme">Done</span>
							</div>
							</li>
							<li class="list-danger">
							<i class=" fa fa-ellipsis-v"></i>
							<div class="task-title">
								<span class="task-title-sp"><a href="#">Extensive collection of plugins</a></span>
								<span class="badge bg-warning">Cool</span>
							</div>
							</li>
							<li class="list-success">
							<i class=" fa fa-ellipsis-v"></i>
							<div class="task-title">
								<span class="task-title-sp"><a href="#">Free updates always, no extra fees.</a></span>
								<span class="badge bg-success">2 Days</span>
							</div>
							</li>
							<li class="list-warning">
							<i class=" fa fa-ellipsis-v"></i>
							<div class="task-title">
								<span class="task-title-sp"><a href="#">More features coming soon</a></span>
								<span class="badge bg-info">Tomorrow</span>
							</div>
							</li>
							<li class="list-info">
							<i class=" fa fa-ellipsis-v"></i>
							<div class="task-title">
								<span class="task-title-sp"><a href="#">Hey, seriously, you should buy this Dashboard</a></span>
								<span class="badge bg-important">Now</span>
							</div>
							</li>
						</ul>
						<a class="btn btn-default btn-sm pull-right" href="#">더보기</a>
					</div>
					</section>
				</div>
			</div>
		</div>
		<!-- // free board area -->
		
		<!-- qna board area -->
		<div class="col-md-6 mb">
			<div class="grey-panel pn panel-height">
				<div class="grey-header">
					<h5>Q & A 게시판</h5>
				</div>
				<div class="col-md-12">
					<section class="task-panel tasks-widget">
					<div class="task-content">
						<ul id="sortable" class="task-list sortable-ui">
							<li class="list-primary">
							<i class=" fa fa-ellipsis-v"></i>
							<div class="task-title">
								<span class="task-title-sp"><a href="#">Dashgum - Admin Panel Theme</a></span>
								<span class="badge bg-theme">Done</span>
							</div>
							</li>
							<li class="list-danger">
							<i class=" fa fa-ellipsis-v"></i>
							<div class="task-title">
								<span class="task-title-sp"><a href="#">Extensive collection of plugins</a></span>
								<span class="badge bg-warning">Cool</span>
							</div>
							</li>
							<li class="list-success">
							<i class=" fa fa-ellipsis-v"></i>
							<div class="task-title">
								<span class="task-title-sp"><a href="#">Free updates always, no extra fees.</a></span>
								<span class="badge bg-success">2 Days</span>
							</div>
							</li>
							<li class="list-warning">
							<i class=" fa fa-ellipsis-v"></i>
							<div class="task-title">
								<span class="task-title-sp"><a href="#">More features coming soon</a></span>
								<span class="badge bg-info">Tomorrow</span>
							</div>
							</li>
							<li class="list-info">
							<i class=" fa fa-ellipsis-v"></i>
							<div class="task-title">
								<span class="task-title-sp"><a href="#">Hey, seriously, you should buy this Dashboard</a></span>
								<span class="badge bg-important">Now</span>
							</div>
							</li>
						</ul>
						<a class="btn btn-default btn-sm pull-right" href="#">더보기</a>
					</div>
					</section>
				</div>
			</div>
		</div>
		<!-- // qna board area -->
	</div>

	<!-- tech board area -->
	<div class="row mt">
		<div class="col-md-12 mb">
			<div class="grey-panel pn panel-height">
				<div class="grey-header">
					<h5>Tech 게시판</h5>
				</div>
				<div class="col-md-12">
					<section class="task-panel tasks-widget">
					<div class="task-content">
						<ul id="sortable" class="task-list sortable-ui">
							<li class="list-primary">
							<i class=" fa fa-ellipsis-v"></i>
							<div class="task-title">
								<span class="task-title-sp"><a href="#">Dashgum - Admin Panel Theme</a></span>
								<span class="badge bg-theme">Done</span>
							</div>
							</li>
							<li class="list-danger">
							<i class=" fa fa-ellipsis-v"></i>
							<div class="task-title">
								<span class="task-title-sp"><a href="#">Extensive collection of plugins</a></span>
								<span class="badge bg-warning">Cool</span>
							</div>
							</li>
							<li class="list-success">
							<i class=" fa fa-ellipsis-v"></i>
							<div class="task-title">
								<span class="task-title-sp"><a href="#">Free updates always, no extra fees.</a></span>
								<span class="badge bg-success">2 Days</span>
							</div>
							</li>
							<li class="list-warning">
							<i class=" fa fa-ellipsis-v"></i>
							<div class="task-title">
								<span class="task-title-sp"><a href="#">More features coming soon</a></span>
								<span class="badge bg-info">Tomorrow</span>
							</div>
							</li>
							<li class="list-info">
							<i class=" fa fa-ellipsis-v"></i>
							<div class="task-title">
								<span class="task-title-sp"><a href="#">Hey, seriously, you should buy this Dashboard</a></span>
								<span class="badge bg-important">Now</span>
							</div>
							</li>
						</ul>
						<a class="btn btn-default btn-sm pull-right" href="#">더보기</a>
					</div>
					</section>
				</div>
			</div>
		</div>
	</div>
	<!-- // tech board area -->
</div>