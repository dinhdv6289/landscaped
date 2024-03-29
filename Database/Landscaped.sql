CREATE DATABASE Landscaped
GO
USE Landscaped
GO

CREATE TABLE Roles
(
	RoleId			INT IDENTITY(1,1) PRIMARY KEY,
	RoleName		NVARCHAR(50) NOT NULL,
	Description		NVARCHAR(200)
)
GO

CREATE TABLE Account
(
	AccountId		INT IDENTITY(1,1) PRIMARY KEY,
	RoleId			INT REFERENCES Roles(RoleId),
	UserName		NVARCHAR(30) UNIQUE NOT NULL,
	Password		NVARCHAR(32) NOT NULL,
	Picture			NVARCHAR(100),
	Compartment		NVARCHAR(50) , -- tên gian hàng
	FullName		NVARCHAR(100),
	HomePhone		NVARCHAR(10) ,
	MobilePhone		NVARCHAR(15) ,
	Email			NVARCHAR(50) ,
	Address			NVARCHAR(250) ,
	State			BIT DEFAULT 0
)
GO

CREATE TABLE Categories
(
	CategoryId		INT IDENTITY(1,1) PRIMARY KEY,
	CategoryName	NVARCHAR(50) NOT NULL,
	Description		NTEXT		
)
GO

CREATE TABLE Products
(
	ProductId		INT IDENTITY(1,1) PRIMARY KEY,
	CategoryId		INT REFERENCES Categories(CategoryId) NOT NULL,
	AccountId		INT REFERENCES Account(AccountId) NOT NULL,
	ProductName		NVARCHAR(50) NOT NULL,
	Price			FLOAT,
	Description		NTEXT,
	DateCreation	DATETIME	DEFAULT GETDATE(),
	DateModify		DATETIME,
	State			BIT DEFAULT 1
)
GO

CREATE TABLE PictureProducts
(
	PictureId		INT IDENTITY(1,1) PRIMARY KEY,
	ProductId		INT REFERENCES Products(ProductId) NOT NULL,
	PathImage		NVARCHAR(100),
	PrimaryImage	BIT DEFAULT 0,		
)
GO
CREATE TABLE Orders
(
	OrderId				INT IDENTITY(1,1) PRIMARY KEY,
	ShipName			NVARCHAR(50)		NOT NULL,
	ShipAddress			NVARCHAR(250)		NOT NULL,
	ShipPhone			NVARCHAR(15)		NOT NULL,
	ShipEmail			NVARCHAR(50)		NOT	NULL,
	DateCreation		DATETIME	DEFAULT GETDATE(),	-- ngày lập hóa đơn
	DeliveryDate		DATETIME				NULL,	-- ngày giao hàng
	State				BIT					DEFAULT 0,	-- đã nhận hàng hay chưa
	Notes				NVARCHAR(500)			NULL	-- yêu cầu của khách hàng
)
GO

CREATE TABLE OrderDetails
(
	OrderDetailId		INT IDENTITY(1,1) PRIMARY KEY,
	OrderId				INT	REFERENCES Orders(OrderId) NOT NULL,
	ProductId			INT REFERENCES Products(ProductId) NOT NULL,
	Quantity			INT					NOT NULL,
	Price				FLOAT				NOT	NULL,
	TotalPrice			FLOAT
)
GO

CREATE TABLE ArticlesCategories
(
	ArticlesCategoryId		INT IDENTITY(1,1) PRIMARY KEY,
	ArticlesCategoryName	NVARCHAR(50) NOT NULL,
	Description				NVARCHAR(50),		
)
GO

CREATE TABLE Articles(
	ArticleId			INT IDENTITY(1,1) PRIMARY KEY,
	ArticlesCategoryId	INT REFERENCES ArticlesCategories(ArticlesCategoryId) NOT NULL,
	Title				NVARCHAR(100) NOT NULL,
	Picture				NVARCHAR(100),
	SubContent			NVARCHAR(150) NOT NULL,
	[Content]			NTEXT,
	DateCreation		DATETIME DEFAULT GETDATE(),
	DateModify			DATETIME,
	State				BIT DEFAULT 1
)
GO

CREATE TABLE FeedBack(
	FeedBackId		INT IDENTITY(1,1) PRIMARY KEY,
	FullName		NVARCHAR(100)		NOT NULL,
	Address			NVARCHAR(100),
	Email			NVARCHAR(100),
	Phone			NVARCHAR(100),
	Title			NVARCHAR(100)		NOT NULL,
	[Content]		NTEXT				NOT NULL,
	DateCreation	DATETIME DEFAULT GETDATE()
)
GO

CREATE TABLE Advertisement -- quảng cáo
(
	AdvertisementId		INT IDENTITY(1,1) PRIMARY KEY,
	Title				NVARCHAR(50),
	Picture				NVARCHAR(100) NOT NULL,
	Link				NVARCHAR(50),
	AdvOrder			INT,
)
GO

INSERT INTO Roles(RoleName,[Description])
	VALUES('admin',N'Quản trị website')
INSERT INTO Roles(RoleName,[Description])
	VALUES('user',N'Khách hàng')
GO

INSERT INTO Account(RoleId,UserName,[Password],Picture,Compartment,FullName,HomePhone,MobilePhone,Email,[Address],State)
	VALUES(1,'badboy','badboy','','','Nguyễn Mạnh Hà','123456789','0936333703','badboy1707@gmail.com','HN',1)
INSERT INTO Account(RoleId,UserName,[Password],Picture,Compartment,FullName,HomePhone,MobilePhone,Email,[Address],State)
	VALUES(2,'123456','123456','','','Nguyễn Mạnh Hà','123456789','0936333703','badboy1707@gmail.com','HN',1)
GO

INSERT INTO Categories(CategoryName,[Description])
	VALUES(N'Vườn Ươm','')
INSERT INTO Categories(CategoryName,[Description])
	VALUES(N'Cây cảnh Việt Nam','')
GO
INSERT INTO Products(CategoryId,AccountId,ProductName,Price,[Description],DateCreation,DateModify,[State])
	VALUES(1,1,N'Cây vớ vẩn','12345678','',GETDATE(),GETDATE(),1)
INSERT INTO Products(CategoryId,AccountId,ProductName,Price,[Description],DateCreation,DateModify,[State])
	VALUES(1,1,N'Cây vớ vẩn hơn','123456789','',GETDATE(),GETDATE(),1)
GO

INSERT INTO PictureProducts(ProductId,PathImage,PrimaryImage)
	VALUES(1,'ProductImages/images.jpg',1)
INSERT INTO PictureProducts(ProductId,PathImage,PrimaryImage)
	VALUES(2,'ProductImages/images.jpg',1)