<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/admin-news" method="get" id="formSubmit">
		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>Tên bài viết</th>
											<th>Mô tả ngắn</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${model.listResult}">
											<tr>
												<td>${item.title}</td>
												<td>${item.shortDescrition}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<ul class="pagination" id="pagination"></ul>
								<input type="hidden" name="page" value="" id="page"/>
								<input type="hidden" name="maxPageItem" value="" id="maxPageItem"/>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- /.main-content -->
	<script type="text/javascript">
		var totalPages = ${model.totalPages};
		var currentPage = ${model.page};
		var visiblePages = ${model.maxPageItem};
		$(function () {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages: totalPages,
				visiblePages: 2,
				startPage: currentPage,
				onPageClick: function (event, page) {
					$('#page').val(page);
					$('#fromSubmit').submit();
				}
			});
		});
	</script>
</body>
</html>