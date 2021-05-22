DROP TABLE IF EXISTS category;

CREATE TABLE category
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    name           VARCHAR(250)  NOT NULL,
    taxable_item   VARCHAR(250)  NOT NULL,
    tax_percentage DECIMAL(3, 2) NOT NULL
);

INSERT INTO category (name, taxable_item,tax_percentage) VALUES
    ('Books and Newspapers','Book','0.05'),
    ('Books and Newspapers','Daily newspaper','0.05'),
    ('Construction works','Construction work','0.08'),
    ('Other','Other','0.00');

