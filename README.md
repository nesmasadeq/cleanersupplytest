# Automation test using Katalon Studio
[![Katalon - 8.2.0](https://img.shields.io/badge/Katalon-8.2.0-2ea44f)](https://)

<a href="https://www.katalon.com/katalon-studio/"><img src="https://d1h3p5fzmizjvp.cloudfront.net/themes/katalon_4/images/pages/kse_landing_page/new_2019/logo%20KS-2.png" width="180" alt="Katalo"/></a>

**Website:** [CleanerSupply](https://www.cleanersupply.com/)

### Quick start
```Java
git clone https://github.com/nesmasadeq/cleanersupplytest
```

### Requirenments
1. Java (JDK)
2. Katalon Studio.
You can download last version of Katalon Studion form https://www.katalon.com/katalon-studio/

### Description
This project is automation testing for CleanerSupply site https://admin-demo.nopcommerce.com using Katalon Studio. 
With three checkout scenarios, header and footer testing.

### Tests covered for this project
Checkout Scenarios:
Scenario 1
1- Navigate to https://www.cleanersupply.com/
2- Search for 'Plastic' term.
3- Select 'Packing Products' and 'Plastic Bags' options from category filter.
4- Select 'Green' from color group filter.
5- Navigte to the resulted product page.
6- Select 'X-Large' size, and 'Green' color.
7- Edit quantity value to be 5.
8- Add this item to the cart.
9- Select blue color, and large size for the same product.
10- add 3 items from this item.
11- Navigate to the cart.
12- Modify products quantities to be 4, and 4.
13- Click on 'Proceed To Checkout'
14- Select 'Checkut As Guest' and move to the next step.
15- Fill Shipping Address and payment method with fake data.
16- Navigate to next step (Review Order).
17- Observe the Checkout Review page content.
18- Close the browser
___
Scenario 2 
1- Navigate to https://www.cleanersupply.com/
2- Hover on 'Tags & Forms' header items.
3- Select 'Computers & Registers' category.
4- From the manufacturer section, select the 'Casio' manufacturer and select 'SP1000' Model.
5- Enter the resulted product and 10 items from it to the cart.
6- Navigate to the cart.
7- Click on 'Proceed To Checkout'
8- Select 'Checkut As Guest' and move to the next step.
9- Fill Shipping Address and payment method with fake data.
10- Navigate to next step (Review Order).
11- Observe the Checkout Review page content.
12- Close the browser
____
Suite 3
1- Navigate to quick order page from the header.
2- Add any 5 products to the quick order list with random quantites between 5 and 50.
3- Add them to the cart
4- Navigate to the cart.
5- Click on 'Proceed To Checkout'
6- Select 'Checkut As Guest' and move to the next step.
7- Fill Shipping Address and payment method with fake data.
8- Navigate to next step (Review Order).
9- Observe the Checkout Review page content.
10- Close the browser
____
Header Test Scenario
Footer Test Scenario

