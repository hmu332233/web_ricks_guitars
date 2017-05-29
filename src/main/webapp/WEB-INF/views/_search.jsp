<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<section id="search">
<div class="container">
	<form>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Email address</label>
	    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
	  </div>
	  <div class="row">
		  <div class="form-group col-6">
		    <label for="buider">buider</label>
		    <select class="form-control" id="exampleSelect1">
		      <option>FENDER</option>
		      <option>MARTIN</option>
		      <option>GIBSON</option>
		      <option>COLLINGS</option>
		      <option>OLSON</option>
		      <option>RYAN</option>
		      <option>PRS</option>
		      <option>ANY</option>
		    </select>
		  </div>
		  <div class="form-group col-6">
		    <label for="model">type</label>
		    <select class="form-control" id="exampleSelect1">
		      <option>ACOUSTIC</option>
		      <option>ELECTRIC</option>
		    </select>
		  </div>
	  </div>
	  <div class="row">
		  <div class="form-group col-6">
		    <label for="element">topWood</label>
		    <select class="form-control" id="exampleSelect1">
		      <option>INDIAN_ROSEWOOD</option>
		      <option>BRAZILIAN_ROSEWOOD</option>
		      <option>MAHOGANY</option>
		      <option>MAPLE</option>
		      <option>COCOBOLO</option>
		      <option>CEDAR</option>
		      <option>ADIRONDACK</option>
		      <option>ALDER</option>
		      <option>SITKA</option>
		    </select>
		  </div>
		  <div class="form-group col-6">
		    <label for="element">backWood</label>
		    <select class="form-control" id="exampleSelect1">
		      <option>INDIAN_ROSEWOOD</option>
		      <option>BRAZILIAN_ROSEWOOD</option>
		      <option>MAHOGANY</option>
		      <option>MAPLE</option>
		      <option>COCOBOLO</option>
		      <option>CEDAR</option>
		      <option>ADIRONDACK</option>
		      <option>ALDER</option>
		      <option>SITKA</option>
		    </select>
		  </div>
	  </div>
	  
	  <button type="submit" class="btn btn-primary">Search</button>
	</form>	
</div>
</section>