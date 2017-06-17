<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="card" >
	<div class="container">
		<div class="row">

			<c:forEach var="instrument" items="${instruments}">
				<div class="col-sm-6 col-md-4 col-lg-3 mt-4">
					<div class="card">
						<div class="card-block">
							<h4 class="card-title mt-3">${instrument.getSpec().getProperty("model")}</h4>
							<div class="meta">
								<a>$ ${instrument.price}</a>
							</div>
							<div class="card-text">${ instrument.getSpec().toHTML()}</div>
						</div>
						<div class="card-footer">
							<div class="d-flex justify-content-between">
								<button class="btn btn-secondary float-right btn-sm" onclick="location.href='/instruments/${instrument.serialNumber}/edit';">edit</button>
								<form action="/instruments/${instrument.serialNumber}" method="POST">
									<input name="_method" type="hidden" value="DELETE" />
									<input type="submit" class="btn btn-secondary float-right btn-sm" value="delete"></button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
</section>