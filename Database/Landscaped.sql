CREATE DATABASE Landscaped
GO
USE Landscaped
GO

CREATE TABLE Account
(
	AccountId		INT IDENTITY(1,1) PRIMARY KEY,
	UserName		NVARCHAR(30) UNIQUE NOT NULL,
	Password		NVARCHAR(32) NOT NULL,
	Picture			NVARCHAR(100),
	Compartment		NVARCHAR(50) NOT NULL, -- tên gian hàng
	HomePhone		NVARCHAR(10),
	MobilePhone		NVARCHAR(15) NOT NULL,
	Email			NVARCHAR(50) NOT NULL,
	Address			NVARCHAR(250) NOT NULL,
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