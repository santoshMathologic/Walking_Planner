/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.5-10.1.13-MariaDB : Database - walking_db1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`walking_db1` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `walking_db1`;

/*Table structure for table `company_details` */

DROP TABLE IF EXISTS `company_details`;

CREATE TABLE `company_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `company_address` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `company_details` */

insert  into `company_details`(`id`,`city`,`company_address`,`company_name`,`country`,`state`) values (1,'BANGALORE','6TH BLOCK 100 FEET ROAD NEAR SONY WORLD SIGNAL JUNCTION,OPP TO RIYA KODALI SHOWROOM, KORMANGALA','Ionidea Enterprise Solutions Private Limited ','India','KA'),(2,'BANGALORE','#32/A,1st Floor,9th Main','Hinduja global Solutions -','India','KA'),(3,'BANGALORE','Brickwork India Pvt. Ltd., 3rd Floor, Raj Alkaa Park, 29/3, & 32/2,','CADEM Technologies Pvt. Ltd.','India','KA'),(4,'BANGALORE','Marks & Spencer, Kormangla, Opposite Oasis Centre, Inner Ring Road, Bangalore','Crane-Bel International Pvt. Ltd.','India','KA'),(5,'BANGALORE','No. 264/75, 36th Cross, 2nd Main','Pragati Automation Pvt Ltd','India','KA'),(6,'BANGALORE','Dharwad Bye Pass (Next to Airtech)','Premier Ltd','India','KA'),(7,'BANGALORE','Pune Satara Road','Nugen Machineries Ltd','India','KA'),(8,'BANGALORE','Bommasandra Industrial Estate','Nagel Special Machines Pvt. Ltd','India','KA'),(9,'BANGALORE','2816 Jammu Colony, St No 1','Miven Mayfran Conveyors Pvt. Ltd.','India','KA'),(10,'BANGALORE','201, Karma Stambh','Mistry Laxman Kadva Machines (P) Ltd.','India','KA'),(11,'BANGALORE','Raheja Palmspring Centre','Micromatic Grinding Technologies Ltd','India','KA'),(12,'BANGALORE','G. T. Road, Suranussi','Mercury Pneumatics Pvt. Ltd.','India','KA'),(13,'BANGALORE','G-506 Lodhika GIDC','Liebherr Machine Tools India Pvt Ltd','India','KA'),(14,'BANGALORE','10/2 Bhaktinagar Station Plot','Krystal Elmec','India','KA'),(15,'BANGALORE','8 / 9th Mile, Tumkur Road','Klad On Design Pvt. Ltd','India','KA'),(16,'BANGALORE','Hinjawadi MIDC, Phase 2, At Post - Maan','Kirpekar Engineering Pvt. Ltd','India','KA'),(17,'BANGALORE','Plot No. 8A, Raisoni Industrial Park','Khushbu Engineers','India','KA'),(18,'BANGALORE','Nadakerappa Industrial Estate','Kawa Press Systems Pvt Ltd','India','KA'),(19,'BANGALORE','353-354 9th Cross, 4th Main','Jash Precision Tools Ltd','India','KA'),(20,'BANGALORE','IV Phase, Peenya Industrial Area','HMT Machine Tools Ltd.','India','KA'),(21,'das','dasda','dsdsa','dsaasd','ewew'),(22,'jjjj','gggg','eewew','vvv','mmmm'),(23,'BANGALORE','Brickwork India Pvt. Ltd. 3rd Floor Raj Alkaa Park 29/3 & 32/2','CADEM Technologies Pvt. Ltd dasdas','India','KA');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`id`,`name`) values (1,'ADMIN'),(2,'SUPER'),(3,'GUEST'),(4,'SUPERVISIOR'),(5,'MANAGER'),(6,'TEAMLEAD');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activation_key` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `employee_no` varchar(255) DEFAULT NULL,
  `extension` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `is_active` bit(1) DEFAULT b'0',
  `last_name` varchar(255) DEFAULT NULL,
  `mobile_no` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telephone_no` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`activation_key`,`email`,`employee_no`,`extension`,`first_name`,`is_active`,`last_name`,`mobile_no`,`password`,`telephone_no`,`username`,`role_id`) values (1,'8e71c602e471c67993c5892929341cbf','rak1994kumar@gmail.com','MIT123','EG124','rakesh','','kumar','8269337580','123456','8269337580','rakesh',1),(5,'8e71c602e471c67993c5892929341cbf','san@gmaail.com','MIT124','EGL124','dasdas','\0','dasdasd','7401465159','1cd09mca13',NULL,'anwar',3),(9,'8e71c602e471c67993c5892929341cbf','san@gmail.com','MIT123','EGL124','dsad','','dsada','74015555','sadasd',NULL,'pankaj',5),(12,'8e71c602e471c67993c5892929341cbf','santsf@gmail.com','MIT123','EGL124','wwwwwwww','','aaaaaaaa','74015555','sadasd',NULL,'jhon',5),(13,'8e71c602e471c67993c5892929341cbf','sandasdtsf@gmail.com','MIT123','EGL124','nnnasdas','','wqwqw','74015555','sadasd',NULL,'ajay',5),(14,'8e71c602e471c67993c5892929341cbf','dasdasda@gmail.com','MIT123','EGL124','mmmmmm','','qqqqqqq','74015555','sadasd',NULL,'david',5),(18,'8e71c602e471c67993c5892929341cbf','pppppppppp@gmail.com','MIT123','EGL124','bbbbbbbbbbb','','qqqqqqq','74015555','sadasd',NULL,'raj',5),(21,'8e71c602e471c67993c5892929341cbf','sahusantosh19862@gmail.com','LNT06459','LNT458','santosh','','sahu','7406465159','1cd09mca13',NULL,'sanjay',1);

/*Table structure for table `user_plan` */

DROP TABLE IF EXISTS `user_plan`;

CREATE TABLE `user_plan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `co_planner` varchar(255) DEFAULT NULL,
  `is_complete` bit(1) DEFAULT b'0',
  `is_locked` bit(1) DEFAULT b'0',
  `is_under_review` bit(1) DEFAULT b'0',
  `is_under_reviewer` bit(1) DEFAULT b'0',
  `mark_delete` bit(1) DEFAULT b'0',
  `owner` varchar(255) DEFAULT NULL,
  `plan_name` varchar(255) NOT NULL,
  `reviewer` varchar(255) DEFAULT NULL,
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_lceex95e5px1xeupw2it2v95p` (`plan_name`),
  UNIQUE KEY `UK_tqunqeltdbndpqbx5vr1arwqh` (`time_stamp`),
  KEY `FKr1gojepx9qoalgmd17gurr1dl` (`user_id`),
  CONSTRAINT `FKr1gojepx9qoalgmd17gurr1dl` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `user_plan` */

insert  into `user_plan`(`id`,`co_planner`,`is_complete`,`is_locked`,`is_under_review`,`is_under_reviewer`,`mark_delete`,`owner`,`plan_name`,`reviewer`,`time_stamp`,`user_id`) values (1,'C1','\0','\0','\0','\0','\0','santosh','PLAN001','santosh','2017-02-11 17:09:50',9),(4,'c2','\0','\0','\0','\0','\0','rakesh','PLAN002','santosh','2017-02-24 17:09:50',9),(5,'c3','\0','\0','\0','\0','\0','sanjay','PLAN003','santosh','2017-02-21 17:09:50',9),(7,NULL,'\0','\0','\0','\0','\0','owner001','PLAN004','santosh','2017-02-05 17:09:50',9),(8,NULL,'\0','\0','\0','\0','\0','SANTOSH','PLAN005','santosh','2017-02-13 17:09:50',9),(9,NULL,'\0','\0','\0','\0','\0','SANTOSH','PLAN006','santosh','2017-02-26 17:09:50',9),(11,NULL,'\0','\0','\0','\0','\0','SANTOSH','PLAN007','santosh','2017-02-28 17:09:50',9),(12,NULL,'\0','\0','\0','\0','\0','SANTOSH','PLAN008','santosh','2017-02-01 17:09:50',9);

/*Table structure for table `walkin_details` */

DROP TABLE IF EXISTS `walkin_details`;

CREATE TABLE `walkin_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `short_venue` varchar(255) NOT NULL,
  `venu` varchar(255) NOT NULL,
  `walking_time` time DEFAULT NULL,
  `walkingdate` date DEFAULT NULL,
  `companydetails_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiv5fvf3ltvkoy9e281mb385py` (`companydetails_id`),
  CONSTRAINT `FKiv5fvf3ltvkoy9e281mb385py` FOREIGN KEY (`companydetails_id`) REFERENCES `company_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

/*Data for the table `walkin_details` */

insert  into `walkin_details`(`id`,`short_venue`,`venu`,`walking_time`,`walkingdate`,`companydetails_id`) values (5,'Bommanhalli','College Road, Vadkun,','12:22:00','2017-01-13',5),(6,'Bommanhalli','Gauge House67, Hadapsar Industrial Estate','12:22:00','2017-01-14',6),(8,'Bommanhalli','Kanta Vikas Gruh Road','12:22:00','2017-01-16',8),(11,'Yeshwantpur','Bommasandra Industrial Estate','12:22:00','2017-01-19',11),(12,'Yeshwantpur','2816 Jammu Colony, St No 1','12:22:00','2017-01-20',12),(13,'Yeshwantpur','Vellalore Road,','12:22:00','2017-01-21',13),(14,'Hadapsar','No. 264/75, 36th Cross, 2nd Main,8th Block, Jayanagar','23:41:58','2017-01-22',14),(15,'Hadapsar','B-14, Ambattur Industrial Estate','12:22:00','2017-01-23',15),(16,'Yeshwantpur','GF 1, 6th Main, KSSIDC Building','12:22:00','2017-01-24',16),(17,'Hadapsar','418, Industrial Area \'A\'\r','23:41:58','2017-01-25',17),(18,'Hadapsar','B - 1/976, Rajpura Road,','12:22:00','2017-01-26',18),(21,'Yeshwantpur','201, Karma Stambh,','12:22:00','2017-01-29',5),(37,'Whitefield','IonIdea Pvt. Ltd # 38-40 EPIP Whitefield Bangalore 560 066. Besides SAP LABS Landmark: KTPO Stop Near Ginger Hotel',NULL,NULL,1),(38,'Whitefield','45/4 Tumkur Road Yeshwanthpur Metro Station Opposite to More Hypermarket Yeshwantpu',NULL,NULL,2),(39,'Bommanhalli','College Road Vadkun',NULL,NULL,23);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
