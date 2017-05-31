<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<section id="form">
	<div class="container">
		<form action="/instruments/search" method="GET">
			<div class="row">
				<div class="col-sm-6 col-lg-4">
					<div class="form-group">
						<label for="serialNumber">serial number</label> 
						<input name="serialNumber" type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="0123456">
					</div>
				</div>
				<div class="col-sm-6 col-lg-4">
					<div class="form-group">
						<label for="price">price</label> 
						<input name="price" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="123.456">
					</div>
				</div>
				<div class="col-sm-6 col-lg-4">
					<div class="form-group">
						<label for="model">model</label> 
						<input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="MD-5">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-6 col-lg-3">
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
				<div class="form-group col-sm-6 col-lg-3">
					<label for="model">type</label> <select class="form-control"
						id="exampleSelect1" name="type">
						<option>Unspecified</option>
						<option>acoustic</option>
						<option>electric</option>
					</select>
				</div>

				<div class="form-group col-sm-6 col-lg-3">
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
				<div class="form-group col-sm-6 col-lg-3">
					<label for="element">backWood</label> <select class="form-control"
						id="exampleSelect1" name="backWood">
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
			</div>

			<button type="submit" class="btn btn-primary">Search</button>
		</form>
	</div>
</section>
