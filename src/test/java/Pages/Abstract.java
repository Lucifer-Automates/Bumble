package Pages;

public class Abstract {

    /***
     * LogIn Locators
     */
    public static String SignInButton = "//a[@data-seo-label=\"sign-in\"]";
    public static String Continue_With_Facebook = "//span[contains(text(),'Continue with Facebook')]";
    public static String EmailFieldSignIn = "//input[@id='email']";
    public static String PasswordFieldSignIn = "//input[@id='pass']";
    public static String LoginButton = "//label[@id='loginbutton']";
    public static String YesButton = "//span[@data-qa-icon-name='floating-action-yes']";
    public static String NoButton = "//span[@data-qa-icon-name='floating-action-no']";
    public static String SuperSwipe = "//span[@data-qa-icon-name='floating-action-superswipe']";
    public static String Profile_SideBar = "//aside//div//div//..//div[@class=\"sidebar__header\"] | //div[@class='sidebar-profile__name']";
    public static String LogoutButtonSideBar = "//div[@class='sidebar-action sidebar-action--logout']";
    public static String LogoutButton = "//span[@class='action text-break-words']//span[contains(text(),'Log out')]";

    /***
     * Match Queue Locators
     */
    public static String MatchQueueFirstTile = "//li[@class=\"scrollable-carousel__item\"][1]";
    public static String Close_Icon = "//span[@data-qa-icon-name=\"generic-close\"]";
    public static String Figure_Icons = "//section//figure[";
    public static String Figure_Yes_Option = "//div[@class='user-card__action user-card__action--yes']";
    public static String Figure_No_Option = "//div[@class='user-card__action user-card__action--no']";







}
