# Test Automation – framework using Selenium and Java
 
- Organized using Page Object Model (POM) structure
- Using asserts to do the verifications asked in different steps
- Using wait methods (trying to avoid thread.sleep)
- Configured Screenshot Capture on failure

## Test 1: Register Test
- Navigate to : https://demo.nopcommerce.com/
- Click LogIn - Menu
- Click Register - button
- Check the title of the page after clicking Register button
- Fill the register form as below:
- Verify that register is success

## Test 2: Login Test
- Navigate to : https://demo.nopcommerce.com/
- Click LogIn - Menu
- Login with the credentials created from Test 1
- Verify that login is successful: 
 “Welcome to our store text” - is displayed
 Log out - Menu is displayed 
- Log out

## Test 3: Dashboard Test 
- Precondition: Log in nopCommerce Application
- Hover over Computers Menu
- Click Notebooks
- Verify that we have navigate to Notebooks Page
- Add the second and the third item on wishlist
- Verify that after every item added a notification with text : The product has been added to your wishlist – is displayed
- Add the fourth, fifth and sixth item on Shopping Cart
- Verify that after every item added a notification with text : The product has been added to your shopping cart –is displayed
- Verify that Wishlist on Menu bar displays 2
- Verify that Shopping Cart on Menu bar displays 3
- Close the browser

## Test 4: Shopping Cart Test 
- Precondition: Test 3
- Hover over Shopping Cart – Menu
- Verify that ‘Go To Cart’ – button is displayed
- Click ‘Go To Cart’ – button
- Verify that we have navigate to Shopping Cart Page
- Verify that following buttons are displayed
- Verify that the prices sum for all items is equal to Total Price in the end of the page
- Click “Update shopping cart” – button
- Check checkbox with text: I agree with the terms of service and I adhere to them unconditionally
- Click “Checkout” – button
- Verify “First name”, “Last name” and “Email” input fields displays the values you entered while Register.
- Fill in the information needed in Billing Address form
- Click “Continue” - button
- In Shipping method, select the second option (Next Day Air)
- Click “Continue” – button
- In Payment method select the first option (Check/Money Order)
- Click “Continue” – button
- In Payment Information click “Continue” – button
- In Confirm Order, verify that the price displayed in Total is the same as the one in step 6.
- Click “Confirm” – button
- Verify your order is done successful and an order number is displayed.
- Close the browser

