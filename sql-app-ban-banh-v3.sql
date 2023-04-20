--thứ tự bảng có thể không đúng, xem xét lại thứ tự nếu tạo bị lỗi
create database app_ban_banh_v3;
USE `app_ban_banh_v3` ;

CREATE TABLE IF NOT EXISTS `app_ban_banh_v3`.`cart` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `soluong` INT NULL DEFAULT NULL,
  `products_id` INT NOT NULL,
  `is_checked` BIT(1) NULL DEFAULT NULL,
  `users_id` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cart_products1_idx` (`products_id` ASC) VISIBLE,
  INDEX `fk_cart_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_cart_products1`
    FOREIGN KEY (`products_id`)
    REFERENCES `app_ban_banh_v3`.`products` (`id`),
  CONSTRAINT `fk_cart_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `app_ban_banh_v3`.`users` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `app_ban_banh_v3`.`thanh_toan_momo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sdt` VARCHAR(20) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `email` VARCHAR(20) NULL DEFAULT NULL,
  `users_id` INT NOT NULL,
  `payments_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_thanh_toan_momo_users1_idx` (`users_id` ASC) VISIBLE,
  INDEX `fk_thanh_toan_momo_payments1_idx` (`payments_id` ASC) VISIBLE,
  CONSTRAINT `fk_thanh_toan_momo_payments1`
    FOREIGN KEY (`payments_id`)
    REFERENCES `app_ban_banh_v3`.`payments` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `app_ban_banh_v3`.`chi_tiet_order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `orders_id` INT NOT NULL,
  `cart_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_chi_tiet_order_orders1_idx` (`orders_id` ASC) VISIBLE,
  INDEX `fk_chi_tiet_order_cart1_idx` (`cart_id` ASC) VISIBLE,
  CONSTRAINT `fk_chi_tiet_order_cart1`
    FOREIGN KEY (`cart_id`)
    REFERENCES `app_ban_banh_v3`.`cart` (`id`),
  CONSTRAINT `fk_chi_tiet_order_orders1`
    FOREIGN KEY (`orders_id`)
    REFERENCES `app_ban_banh_v3`.`orders` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `app_ban_banh_v3`.`users` (
  `id` VARCHAR(255) NOT NULL,
  `ho_ten` VARCHAR(20) NULL DEFAULT NULL,
  `pass_word` VARCHAR(20) NULL DEFAULT NULL,
  `email` VARCHAR(20) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `app_ban_banh_v3`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ngay_tao_don` VARCHAR(20) NULL DEFAULT NULL,
  `tong_tien` INT NULL DEFAULT NULL,
  `trang_thai_don_hang` VARCHAR(20) NULL DEFAULT NULL,
  `momo_token` TEXT NULL DEFAULT NULL,
  `sdt` VARCHAR(45) NULL DEFAULT NULL,
  `soluong` INT NULL DEFAULT NULL,
  `tongtien` DOUBLE NULL DEFAULT NULL,
  `diachigiaohang` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `app_ban_banh_v3`.`image_data` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `imagedata` LONGBLOB NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `type` VARCHAR(255) NULL DEFAULT NULL,
  `products_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_image_data_products1_idx` (`products_id` ASC) VISIBLE,
  CONSTRAINT `fk_image_data_products1`
    FOREIGN KEY (`products_id`)
    REFERENCES `app_ban_banh_v3`.`products` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `app_ban_banh_v3`.`product_yeu_thich` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_product` INT NULL DEFAULT NULL,
  `users_id` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_product` (`id_product` ASC) VISIBLE,
  INDEX `fk_product_yeu_thich_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_yeu_thich_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `app_ban_banh_v3`.`users` (`id`),
  CONSTRAINT `product_yeu_yhich_ibfk_2`
    FOREIGN KEY (`id_product`)
    REFERENCES `app_ban_banh_v3`.`products` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `app_ban_banh_v3`.`payments` (
  `id` INT NOT NULL,
  `phuong_thuc_thanh_toan` VARCHAR(20) NULL DEFAULT NULL,
  `users_id` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_payments_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_payments_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `app_ban_banh_v3`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `app_ban_banh_v3`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ten_sp` VARCHAR(255) NULL DEFAULT NULL,
  `mo_ta` TEXT NULL DEFAULT NULL,
  `gia` DOUBLE NULL DEFAULT NULL,
  `so_vote` INT NULL DEFAULT NULL,
  `category_id` INT NOT NULL,
  `giam_gia` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_products_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_products_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `app_ban_banh_v3`.`category` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `app_ban_banh_v3`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ten_category` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `app_ban_banh_v3`.`file_data` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `file_path` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `type` VARCHAR(255) NULL DEFAULT NULL,
  `products_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_file_data_products1_idx` (`products_id` ASC) VISIBLE,
  CONSTRAINT `fk_file_data_products1`
    FOREIGN KEY (`products_id`)
    REFERENCES `app_ban_banh_v3`.`products` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci