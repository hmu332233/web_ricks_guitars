<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="form">
	<div class="container">
		<form action="${param.action}" method="POST">
			<c:if test="${param.method=='PUT'}">
				<input type="hidden" name="_method" value="PUT" />
			</c:if>
			<div class="d-flex justify-content-center">
				<div class="row col-sm-12 col-lg-6">
					<div class="col-6">
						<div class="col-12">
							<div class="form-group">
								<label for="serialNumber">serial number</label> <input
									name="serialNumber" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="0123456">
							</div>
						</div>
						<div class="col-12">
							<div class="form-group">
								<label for="price">price</label> <input name="price" type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="123.456">
							</div>
						</div>
						<div class="col-12">
							<div class="form-group">
								<label for="model">model</label> <input name="model" type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="MD-5">
							</div>
						</div>
						<div class="col-12">
							<div class="form-group">
								<label for="model">numStrings</label> <input name="numStrings" type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="6">
							</div>
						</div>
					</div>
					<div class="col-6">
						<div class="form-group col-12">
							<label for="buider">builder</label> <select class="form-control"
								id="exampleSelect1" name="builder">
								<option>Unspecified</option>
								<option>Fender</option>
								<option>Martin</option>
								<option>Gibson</option>
								<option>Collings</option>
								<option>Olson</option>
								<option>Ryan</option>
								<option>PRS</option>
							</select>
						</div>
						<div class="form-group col-12">
							<label for="model">type</label> <select class="form-control"
								id="exampleSelect1" name="type">
								<option>Unspecified</option>
								<option>acoustic</option>
								<option>electric</option>
							</select>
						</div>

						<div class="form-group col-12">
							<label for="element">topWood</label> <select class="form-control"
								id="exampleSelect1" name="topWood">
								<option>Unspecified</option>
								<option>Indian Rosewood</option>
								<option>Brazilian Rosewood</option>
								<option>Mahogany</option>
								<option>Maple</option>
								<option>Cocobolo</option>
								<option>Cedar</option>
								<option>Adirondack</option>
								<option>Alder</option>
								<option>Sitka</option>
							</select>
						</div>
						<div class="form-group col-12">
							<label for="element">backWood</label> <select
								class="form-control" id="exampleSelect1" name="backWood">
								<option>Unspecified</option>
								<option>Indian Rosewood</option>
								<option>Brazilian Rosewood</option>
								<option>Mahogany</option>
								<option>Maple</option>
								<option>Cocobolo</option>
								<option>Cedar</option>
								<option>Adirondack</option>
								<option>Alder</option>
								<option>Sitka</option>
							</select>
						</div>
						<div class="form-group col-12">
							<label for="element">instrumentType</label> <select
								class="form-control" id="exampleSelect1" name="instrumentType">
								<option>Guitar</option>
							</select>
						</div>
					</div>
				</div>

				<button type="submit" class="btn btn-primary">Search</button>
			</div>
		</form>
	</div>
</section>


<!-- <section id="form"> -->
<!-- 	<div class="container"> -->
<!-- 		<form action="/instruments" method="POST"> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-sm-6 col-lg-4"> -->
<!-- 					<div class="form-group"> -->
<!-- 						<label for="serialNumber">serial number</label>  -->
<!-- 						<input name="serialNumber" type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="0123456"> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="col-sm-6 col-lg-4"> -->
<!-- 					<div class="form-group"> -->
<!-- 						<label for="price">price</label>  -->
<!-- 						<input name="price" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="123.456"> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="col-sm-6 col-lg-4"> -->
<!-- 					<div class="form-group"> -->
<!-- 						<label for="model">model</label>  -->
<!-- 						<input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="MD-5"> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="form-group col-sm-6 col-lg-3"> -->
<!-- 					<label for="buider">builder</label> <select class="form-control" -->
<!-- 						id="exampleSelect1" name="builder"> -->
<!-- 						<option>Unspecified</option> -->
<!-- 						<option>Fender</option> -->
<!-- 						<option>Martin</option> -->
<!-- 						<option>Gibson</option> -->
<!-- 						<option>Collings</option> -->
<!-- 						<option>Olson</option> -->
<!-- 						<option>Ryan</option> -->
<!-- 						<option>PRS</option> -->
<!-- 					</select> -->
<!-- 				</div> -->
<!-- 				<div class="form-group col-sm-6 col-lg-3"> -->
<!-- 					<label for="model">type</label> <select class="form-control" -->
<!-- 						id="exampleSelect1" name="type"> -->
<!-- 						<option>Unspecified</option> -->
<!-- 						<option>acoustic</option> -->
<!-- 						<option>electric</option> -->
<!-- 					</select> -->
<!-- 				</div> -->

<!-- 				<div class="form-group col-sm-6 col-lg-3"> -->
<!-- 					<label for="element">topWood</label> <select class="form-control" -->
<!-- 						id="exampleSelect1" name="topWood"> -->
<!-- 						<option>Unspecified</option> -->
<!-- 						<option>Indian Rosewood</option> -->
<!-- 						<option>Brazilian Rosewood</option> -->
<!-- 						<option>Mahogany</option> -->
<!-- 						<option>Maple</option> -->
<!-- 						<option>Cocobolo</option> -->
<!-- 						<option>Cedar</option> -->
<!-- 						<option>Adirondack</option> -->
<!-- 						<option>Alder</option> -->
<!-- 						<option>Sitka</option> -->
<!-- 					</select> -->
<!-- 				</div> -->
<!-- 				<div class="form-group col-sm-6 col-lg-3"> -->
<!-- 					<label for="element">backWood</label> <select class="form-control" -->
<!-- 						id="exampleSelect1" name="backWood"> -->
<!-- 						<option>Unspecified</option> -->
<!-- 						<option>Indian Rosewood</option> -->
<!-- 						<option>Brazilian Rosewood</option> -->
<!-- 						<option>Mahogany</option> -->
<!-- 						<option>Maple</option> -->
<!-- 						<option>Cocobolo</option> -->
<!-- 						<option>Cedar</option> -->
<!-- 						<option>Adirondack</option> -->
<!-- 						<option>Alder</option> -->
<!-- 						<option>Sitka</option> -->
<!-- 					</select> -->
<!-- 				</div> -->
<!-- 			</div> -->

<!-- 			<button type="submit" class="btn btn-primary">Search</button> -->
<!-- 		</form> -->
<!-- 	</div> -->
<!-- </section> -->