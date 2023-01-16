# SeleniumMavenParallel

The website to perform project is https://demo.activeitzone.com/ecommerce/

#The requirement of project as follows:

- Login Admin Page: check invaid email, invaid password and login success.
- Manage Brand, Manage Category, Manage Product on Admin Page (Add, Edit, Delete,...).
- Run full flow from: Login Admin Page > Add Brand > Add Category > Add Product.
- Check Detail 1 product on User page that has added from Admin Page.
- Search Product, check Table (Name column).
- Log, Report + Screenshot for failed cases (Allure or Extent).
- Parallel Execution for maximum 4 threads with independent cases.

#To check the final project please focus and run the following files:

#Data test: dataTestProject.xlsx

#File for Login feature: FPrjLoginCMSTest.java (LoginCMSPage.java)

#File for Brand Management (Add, Edit, Delete): FPrjBrandTest.java (FPrjBrandPage.java)

#File for Category (Add): FPrjCategoryTest.java (FPrjCategoryPage.java)

#File for Product (Add): FPrjProductTest.java (FPrjProductPage.java)

#Run full flow from: Login Admin Page > Add Brand > Add Category > Add Product: FPrjBrandCateProductFollow.xml (Suites)

#Check detail product on User page that has added from Admin page: run file FPrjCheckAddedProOnUserTest.java

#Run Parallel Execution (Multi browsers: run chrome, firefox, edge with 3 rows data): LoginParallelParameters.xml (Suites)


#NOT DONE YET, WILL BE CONTINUED ... :)
