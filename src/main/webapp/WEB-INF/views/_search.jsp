<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section id="form">
	<div class="container">
		<form action="/instruments/search" method="GET">
			<div class="row">
				<div class="form-group col-sm-6 col-lg-3" id="instrumentType">
					<label for="element">instrumentType</label> <select
						class="form-control" id="instrumentType_select" name="instrumentType">
						<option>Unspecified</option>
						<option>Guitar</option>
						<option>Mandolin</option>
						<option>Banjo</option>
						<option>Dobro</option>
						<option>Fiddle</option>
						<option>Bass</option>
					</select>
				</div>
			</div>
			<div class="row mt-5">
				<div class="col-sm-6 col-lg-3">
					<div class="form-group">
						<label for="serialNumber">serial number</label> <input
							name="serialNumber" type="text" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							placeholder="0123456">
					</div>
				</div>
				<div class="col-sm-6 col-lg-3">
					<div class="form-group">
						<label for="model">model</label> <input name="model" type="text"
							class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" placeholder="MD-5">
					</div>
				</div>
				<div class="col-sm-6 col-lg-3" id="numStrings">
					<div class="form-group">
						<label for="model">numStrings</label> <input name="numStrings"
							type="text" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" placeholder="6">
					</div>
				</div>
			</div>

			<div class="row mt-5">
				<div class="form-group col-sm-6 col-lg-3" id="builder">
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
				<div class="form-group col-sm-6 col-lg-3" id="model">
					<label for="model">type</label> <select class="form-control"
						id="exampleSelect1" name="type">
						<option>Unspecified</option>
						<option>acoustic</option>
						<option>electric</option>
					</select>
				</div>

				<div class="form-group col-sm-6 col-lg-3" id="topWood">
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
				<div class="form-group col-sm-6 col-lg-3" id="backWood">
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

			<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-warning">Search</button>
			</div>

		</form>
	</div>
</section>
