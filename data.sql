drop table instruments;

CREATE TABLE INSTRUMENTS (
	serialNumber    text, -- 시리얼넘버(기본키, 고유)
	price    		double, -- 가격
	instrumentType  text, 
	builder    		text, 
    model    		text, -- 모델명
    type    		text, 
	numStrings 		text, -- 줄 수
	topWood 		text,  
    backWood 		text  
);

INSERT INTO INSTRUMENTS(serialNumber,price,instrumentType,builder,model,type,numStrings,topWood,backWood)
VALUES ('11277',3999.95,'Guitar','Collings','CJ','acoustic','6','Indian Rosewood','Sitka');

INSERT INTO INSTRUMENTS(serialNumber,price,instrumentType,builder,model,type,numStrings,topWood,backWood)
VALUES ('122784',5495.95,'Guitar','Martin','D-18','acoustic','6','Mahogany','Adirondack');

INSERT INTO INSTRUMENTS(serialNumber,price,instrumentType,builder,model,type,numStrings,topWood,backWood)
VALUES ('V95693',1499.95,'Guitar','Fender','Stratocastor','electric','6','Alder','Alder');

INSERT INTO INSTRUMENTS(serialNumber,price,instrumentType,builder,model,type,numStrings,topWood,backWood)
VALUES ('V9512',1549.95,'Guitar','Fender','Apple','electric','6','Alder','Alder');

INSERT INTO INSTRUMENTS(serialNumber,price,instrumentType,builder,model,type,numStrings,topWood,backWood)
VALUES ('70108276',2295.95,'Guitar','Gibson','TTD','electric','6','Maple','Maple');

INSERT INTO INSTRUMENTS(serialNumber,price,instrumentType,builder,model,type,numStrings,topWood,backWood)
VALUES ('33675',225.95,'Banjo','PRS','TTE','acoustic','12','','Maple');

INSERT INTO INSTRUMENTS(serialNumber,price,instrumentType,builder,model,type,numStrings,topWood,backWood)
VALUES ('3578',2225.95,'Banjo','Ryan','Les Paul','acoustic','12','','Maple');

select * from instruments;

#SELECT * FROM INSTRUMENTS WHERE serialNumber='V9512' AND price='';