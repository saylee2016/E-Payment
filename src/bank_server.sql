# HeidiSQL Dump 
#
# --------------------------------------------------------
# Host:                 127.0.0.1
# Database:             bank_server
# Server version:       5.0.27-community-nt
# Server OS:            Win32
# Target-Compatibility: Standard ANSI SQL
# HeidiSQL version:     3.2 Revision: 1129
# --------------------------------------------------------

/*!40100 SET CHARACTER SET latin1;*/
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ANSI';*/
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;*/


#
# Database structure for database 'bank_server'
#

CREATE DATABASE /*!32312 IF NOT EXISTS*/ "bank_server" /*!40100 DEFAULT CHARACTER SET latin1 */;

USE "bank_server";


#
# Table structure for table 'account_info'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "account_info" (
  "account_id" int(10) unsigned NOT NULL auto_increment,
  "account_user_id" int(50) unsigned default NULL,
  "secret_pin" varchar(500) NOT NULL,
  "account_type" varchar(50) NOT NULL,
  "balance" int(10) unsigned NOT NULL,
  "bank_share" blob,
  PRIMARY KEY  ("account_id")
) /*!40100 DEFAULT CHARSET=latin1*/;



#
# Table structure for table 'transaction_table'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "transaction_table" (
  "transaction_id" int(50) unsigned NOT NULL auto_increment,
  "user_id" int(50) unsigned NOT NULL,
  "amount" int(10) unsigned NOT NULL,
  "date" date default NULL,
  "time" time default NULL,
  "otp" int(10) unsigned default NULL,
  PRIMARY KEY  ("transaction_id")
) /*!40100 DEFAULT CHARSET=latin1*/;



#
# Table structure for table 'user_table'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "user_table" (
  "u_id" int(10) unsigned NOT NULL auto_increment,
  "first_name" varchar(50) default NULL,
  "last_name" varchar(50) default NULL,
  "gender" varchar(50) default NULL,
  "enail_id" varchar(50) default NULL,
  "mob" varchar(50) default NULL,
  "username" varchar(50) default NULL,
  "password" varchar(50) default NULL,
  PRIMARY KEY  ("u_id")
) /*!40100 DEFAULT CHARSET=latin1*/;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE;*/
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;*/
