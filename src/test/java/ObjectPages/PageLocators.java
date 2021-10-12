package ObjectPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

// Due to the size of this assessment - I'm keeping all the page locators local to this file.

public class PageLocators {
    WebDriver driver;
    // Cookies pop up/ Privacy Page
    By acceptCookies = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
    By acceptCookiesAssertion = By.id("accept-recommended-btn-handler");

    // Filter Options
    By AreaOfStudyFilter = By.id("mentor-filter-degree");
    By baComparativeLiterature = By.id("react-select-2-option-0");
    By baComparativeLiteratureAndFilmStudies = By.id("react-select-2-option-1");
    By baDrama = By.id("react-select-2-option-2");

    By countriesFilter = By.id("mentor-filter-country");
    By filterOnUnitedKingdom = By.id("react-select-3-option-0");

    By degreeLevelFilter = By.id("mentor-filter-degree_level");
    By filterOnAlumni = By.id("react-select-4-option-0");

    By buddyReadMoreButton = By.id("read-more-5dbc65750d7f07012a046bf1");

    //Chat Page
    By registerAsUser = By.id("register");
    By testInput = By.id("chat-text-input");
    By senMessageBtn = By.xpath("//*[@id=\"chat-page\"]/div/div/div/div/div[3]/form/button[1]");
    By chatPanel = By.id("chat-message-61660039c4f8ff21159f906c");

    // Sign-up Page
    By firstNameInput = By.id("first-name");
    By lastNameInput = By.id("last-name");
    By userEmailInput = By.id("email");
    By InputPassword = By.id("password");
    By confirmPassword = By.id("confirm-password");
    By privacyCheckBox = By.id("privacy");
    By continueToAccount = By.id("continue");

    // Sign-up Page 2
    By dateOfEntry = By.id("dateOfEntry");
    By dateOfEntryOption1 = By.xpath("//*[@id=\"dateOfEntry\"]/optgroup[4]/option[1]");
    By countryOfChoice = By.id("country");
    By afghanistan = By.id("react-select-2-option-0");
    By degreeLevelInput = By.id("degree-level");
    By postGradResearchOption = By.xpath("//*[@id=\"degree-level\"]/option[2]");
    By areaOfStudy_IDK = By.className("iy4W");
    By localePreference = By.id("localePreference");
    By localePreferenceEnglish = By.id("react-select-4-option-0");
    By dob = By.id("611cf98c39bbf54c6bf343ec");
    By whatIndustry = By.id("602cd79a992dc803701c601f");
    By industryTechnologyOption = By.xpath("//*[@id=\"602cd79a992dc803701c601f\"]/option[4]");
    By isDualNationality = By.id("610a5c5d60754e3e5d7f03d4");
    By isDualNationality_yes = By.xpath("//*[@id=\"610a5c5d60754e3e5d7f03d4\"]/option[3]");
    By agreeToMarketing = By.id("marketing");

    // Signed In Page
    By settingsIcon = By.id("settings-tab");

    // WebDriver page set-up
    public PageLocators(WebDriver driver) {
        this.driver= driver;
    }

    //@Before 'URL + Browser page start-up'
    public void browserSetup(){
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/src/drivers/chromedriver-MacOS");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS );
        driver.manage().window().maximize();
        driver.navigate().to("https://unibuddy.co/pwa/demo-university/buddies/students");
    }

    //@After 'ending of session'
    public void endSession(){
        driver.close();
        driver.quit();
    }


    public void filterOnBAComparativeLiterature() throws InterruptedException {
        driver.findElement(AreaOfStudyFilter).click();
        Thread.sleep(1500);
        driver.findElement(baComparativeLiterature).click();
    }

    public void filterOnBAComparativeLiteratureAndFilmStudies() throws InterruptedException {
        driver.findElement(AreaOfStudyFilter).click();
        Thread.sleep(1500);
        driver.findElement(baComparativeLiteratureAndFilmStudies).click();
    }

    public void filterOnBADrama() throws InterruptedException {
        driver.findElement(AreaOfStudyFilter).click();
        Thread.sleep(1500);
        driver.findElement(baDrama).click();
    }

    public void userFiltersOnUnitedKingdom() throws InterruptedException {
        driver.findElement(countriesFilter).click();
        Thread.sleep(1500);
        driver.findElement(filterOnUnitedKingdom).click();
    }

    public void userFiltersOnAlumni() throws InterruptedException {
        driver.findElement(degreeLevelFilter).click();
        Thread.sleep(1500);
        driver.findElement(filterOnAlumni).click();
    }

    public boolean cardNamesIsVisible() throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElement(buddyReadMoreButton).isDisplayed();
    }

    public void clickToReadMoreAboutBuddy() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(buddyReadMoreButton).click();
    }

    public void chatToBuddy() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mentor-5dbc65750d7f07012a046bf1-container\"]/div[2]/div/div[3]/button")));
        driver.findElement(By.xpath("//*[@id=\"mentor-5dbc65750d7f07012a046bf1-container\"]/div[2]/div/div[3]/button")).click();
    }

    public void acceptCookies() throws InterruptedException {
        Thread.sleep(3000);
        if (driver.findElement(acceptCookies).isDisplayed()){
            driver.findElement(acceptCookies).click();
            if(driver.findElement(acceptCookiesAssertion).isDisplayed())
            {
                driver.findElement(acceptCookiesAssertion).click();
            }else{
                Thread.sleep(1000);
            }
        }else{
            Thread.sleep(1000);
        }
    }

    public void navigateToRegisteration() throws InterruptedException {
        if (driver.findElement(registerAsUser).isDisplayed()){
            driver.findElement(registerAsUser).click();
        }else{
            driver.navigate().to("https://unibuddy.co/pwa/demo-university/auth/register");
            if (driver.findElement(acceptCookies).isDisplayed()){
            driver.findElement(acceptCookies).click();
            }else{
                Thread.sleep(1000);
            }
        }Thread.sleep(1000);
    }

    public void navigateDirectlyToRegisteration() throws InterruptedException {
        driver.navigate().to("https://unibuddy.co/pwa/demo-university/auth/register");
        if (driver.findElement(acceptCookies).isDisplayed()){
            Thread.sleep(3000);
            driver.findElement(acceptCookies).click();
        }else{
            Thread.sleep(3000);
        }
    }

    public void navigateDirectlyToChatPage() throws InterruptedException {
        driver.navigate().to("https://unibuddy.co/pwa/demo-university/inbox/pre/5dbc65750d7f07012a046bf1?buddyPosition=1");
        if (driver.findElement(acceptCookies).isDisplayed()){
            Thread.sleep(3000);
            driver.findElement(acceptCookies).click();
        }else{
            Thread.sleep(3000);
        }
    }

    public void navigateDirectlyToBuddyPage() throws InterruptedException {
        driver.navigate().to("https://unibuddy.co/pwa/demo-university/buddies/students/5dbc65750d7f07012a046bf1?buddyPosition=1");
        if (driver.findElement(acceptCookies).isDisplayed()){
            Thread.sleep(3000);
            driver.findElement(acceptCookies).click();
        }else{
            Thread.sleep(3000);
        }
    }

    public void registerAsUser(){
        //Generating random string characters.
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random randomLetters = new Random();
        String generatedString = randomLetters.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        //Generating alpha numeric
        int numericalLimit = 48; // numeral '0'
        int letterLimit = 122; // letter 'z'
        int targetPwordLength = 10;
        Random randomLettersAndNumbers = new Random();
        String generatedAlphaNumericalString = randomLettersAndNumbers.ints(numericalLimit, letterLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetPwordLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        //Using these random Characters for the credentials
        driver.findElement(firstNameInput).sendKeys(generatedString);
        driver.findElement(lastNameInput).sendKeys(generatedString);
        driver.findElement(userEmailInput).sendKeys(generatedString+"@gmail.com");

        //make password alphanumeric for better reach
        driver.findElement(InputPassword).sendKeys(generatedAlphaNumericalString);
        driver.findElement(confirmPassword).sendKeys(generatedAlphaNumericalString);
        driver.findElement(privacyCheckBox).click();
        driver.findElement(continueToAccount).click();
    }

    public void stepTwoRegisteration() throws InterruptedException {
        //When do you hope to join us? *
        driver.findElement(dateOfEntry).click();
        Thread.sleep(2000);
        driver.findElement(dateOfEntryOption1).click();

       //Where do you live? *
        driver.findElement(countryOfChoice).click();
        Thread.sleep(2000);
        driver.findElement(afghanistan).click();
        Thread.sleep(2000);

        //What degree level are you interested in? *
        driver.findElement(degreeLevelInput).click();
        Thread.sleep(2000);
        driver.findElement(postGradResearchOption).click();
        Thread.sleep(2000);

        //Area of study *
        driver.findElement(areaOfStudy_IDK).click();
        Thread.sleep(2000);

        //Preferred language for notifications? *
        driver.findElement(localePreference).click();
        Thread.sleep(2000);
        driver.findElement(localePreferenceEnglish).click();

        //Generate Random Date of birth
        final java.text.SimpleDateFormat DATE_FORMAT = new java.text.SimpleDateFormat("dd/MM/yyyy");
        Random r = new Random();
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.set(java.util.Calendar.MONTH, Math.abs(r.nextInt()) % 12);
        c.set(java.util.Calendar.DAY_OF_MONTH, Math.abs(r.nextInt()) % 30);
        c.setLenient(true);

        //Date of Birth *
        driver.findElement(dob).sendKeys(DATE_FORMAT.format(c.getTime()));

        //Which industry are you interested in? *
        driver.findElement(whatIndustry).click();
        Thread.sleep(1000);
        driver.findElement(industryTechnologyOption).click();
        Thread.sleep(1000);

        //Dual Nationality *
        driver.findElement(isDualNationality).click();
        driver.findElement(isDualNationality_yes).click();

        //Agree to marketing
        driver.findElement(agreeToMarketing).click();

        //continue
        driver.findElement(continueToAccount).click();
    }

    public boolean settingsTabIsVisible() throws InterruptedException {
        Thread.sleep(3000);
        driver.getTitle().equals("Unibuddy - Register Details");
        return driver.findElement(settingsIcon).isDisplayed();
    }

    public boolean chatReturnsPromptToRegister(){
        return driver.findElement(registerAsUser).isDisplayed();
    }

    public boolean userSendsGreetingsToBuddy() throws InterruptedException {
        String GreetingMessage = "Hi my name is Wilson, I am currently working as a Test Automation Engineer, its a pleasure to meet you ;)";
        driver.findElement(testInput).isDisplayed();
        driver.findElement(testInput).click();
        driver.findElement(testInput).sendKeys(GreetingMessage);
        driver.findElement(senMessageBtn).click();
        Thread.sleep(2500);
        System.out.println("GreetingMessage");
        return driver.findElement(chatPanel).equals("Delivered");
    }

}


