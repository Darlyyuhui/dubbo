package com.darly.dubbo.framework.common.useragent;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/10/28 16:16
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
public enum Browser {
    OPERA(Manufacturer.OPERA, (Browser)null, 1, "Opera", new String[]{"Opera"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.PRESTO, "Opera\\/(([\\d]+)\\.([\\w]+))"),
    OPERA_MINI(Manufacturer.OPERA, OPERA, 20, "Opera Mini", new String[]{"Opera Mini"}, (String[])null, BrowserType.MOBILE_BROWSER, RenderingEngine.PRESTO, (String)null),
    OPERA10(Manufacturer.OPERA, OPERA, 10, "Opera 10", new String[]{"Opera/9.8"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.PRESTO, "Version\\/(([\\d]+)\\.([\\w]+))"),
    OPERA9(Manufacturer.OPERA, OPERA, 5, "Opera 9", new String[]{"Opera/9"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.PRESTO, (String)null),
    KONQUEROR(Manufacturer.OTHER, (Browser)null, 1, "Konqueror", new String[]{"Konqueror"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.KHTML, "Konqueror\\/(([0-9]+)\\.?([\\w]+)?(-[\\w]+)?)"),
    OUTLOOK(Manufacturer.MICROSOFT, (Browser)null, 100, "Outlook", new String[]{"MSOffice"}, (String[])null, BrowserType.EMAIL_CLIENT, RenderingEngine.WORD, "MSOffice (([0-9]+))"),
    OUTLOOK2007(Manufacturer.MICROSOFT, OUTLOOK, 107, "Outlook 2007", new String[]{"MSOffice 12"}, (String[])null, BrowserType.EMAIL_CLIENT, RenderingEngine.WORD, (String)null),
    OUTLOOK2010(Manufacturer.MICROSOFT, OUTLOOK, 108, "Outlook 2010", new String[]{"MSOffice 14"}, (String[])null, BrowserType.EMAIL_CLIENT, RenderingEngine.WORD, (String)null),
    IE(Manufacturer.MICROSOFT, (Browser)null, 1, "Internet Explorer", new String[]{"MSIE"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.TRIDENT, "MSIE (([\\d]+)\\.([\\w]+))"),
    OUTLOOK_EXPRESS7(Manufacturer.MICROSOFT, IE, 110, "Windows Live Mail", new String[]{"Outlook-Express/7.0"}, (String[])null, BrowserType.EMAIL_CLIENT, RenderingEngine.TRIDENT, (String)null),
    IEMOBILE7(Manufacturer.MICROSOFT, IE, 121, "IE Mobile 7", new String[]{"IEMobile 7"}, (String[])null, BrowserType.MOBILE_BROWSER, RenderingEngine.TRIDENT, (String)null),
    IEMOBILE6(Manufacturer.MICROSOFT, IE, 120, "IE Mobile 6", new String[]{"IEMobile 6"}, (String[])null, BrowserType.MOBILE_BROWSER, RenderingEngine.TRIDENT, (String)null),
    IE9(Manufacturer.MICROSOFT, IE, 90, "Internet Explorer 9", new String[]{"MSIE 9"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.TRIDENT, (String)null),
    IE8(Manufacturer.MICROSOFT, IE, 80, "Internet Explorer 8", new String[]{"MSIE 8"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.TRIDENT, (String)null),
    IE7(Manufacturer.MICROSOFT, IE, 70, "Internet Explorer 7", new String[]{"MSIE 7"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.TRIDENT, (String)null),
    IE6(Manufacturer.MICROSOFT, IE, 60, "Internet Explorer 6", new String[]{"MSIE 6"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.TRIDENT, (String)null),
    IE5_5(Manufacturer.MICROSOFT, IE, 55, "Internet Explorer 5.5", new String[]{"MSIE 5.5"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.TRIDENT, (String)null),
    IE5(Manufacturer.MICROSOFT, IE, 50, "Internet Explorer 5", new String[]{"MSIE 5"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.TRIDENT, (String)null),
    CHROME(Manufacturer.GOOGLE, (Browser)null, 1, "Chrome", new String[]{"Chrome"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.WEBKIT, "Chrome\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"),
    CHROME10(Manufacturer.GOOGLE, CHROME, 15, "Chrome 10", new String[]{"Chrome/10"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.WEBKIT, (String)null),
    CHROME9(Manufacturer.GOOGLE, CHROME, 10, "Chrome 9", new String[]{"Chrome/9"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.WEBKIT, (String)null),
    CHROME8(Manufacturer.GOOGLE, CHROME, 5, "Chrome 8", new String[]{"Chrome/8"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.WEBKIT, (String)null),
    OMNIWEB(Manufacturer.OTHER, (Browser)null, 2, "Omniweb", new String[]{"OmniWeb"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.WEBKIT, (String)null),
    SAFARI(Manufacturer.APPLE, (Browser)null, 1, "Safari", new String[]{"Safari"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.WEBKIT, "Version\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?)"),
    SAFARI5(Manufacturer.APPLE, SAFARI, 3, "Safari 5", new String[]{"Version/5"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.WEBKIT, (String)null),
    MOBILE_SAFARI(Manufacturer.APPLE, SAFARI, 2, "Mobile Safari", new String[]{"Mobile Safari", "Mobile/"}, (String[])null, BrowserType.MOBILE_BROWSER, RenderingEngine.WEBKIT, (String)null),
    SAFARI4(Manufacturer.APPLE, SAFARI, 4, "Safari 4", new String[]{"Version/4"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.WEBKIT, (String)null),
    APPLE_MAIL(Manufacturer.APPLE, (Browser)null, 50, "Apple Mail", new String[]{"AppleWebKit"}, (String[])null, BrowserType.EMAIL_CLIENT, RenderingEngine.WEBKIT, (String)null),
    LOTUS_NOTES(Manufacturer.OTHER, (Browser)null, 3, "Lotus Notes", new String[]{"Lotus-Notes"}, (String[])null, BrowserType.EMAIL_CLIENT, RenderingEngine.OTHER, "Lotus-Notes\\/(([\\d]+)\\.([\\w]+))"),
    THUNDERBIRD(Manufacturer.MOZILLA, (Browser)null, 110, "Thunderbird", new String[]{"Thunderbird"}, (String[])null, BrowserType.EMAIL_CLIENT, RenderingEngine.GECKO, "Thunderbird\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"),
    THUNDERBIRD3(Manufacturer.MOZILLA, THUNDERBIRD, 130, "Thunderbird 3", new String[]{"Thunderbird/3"}, (String[])null, BrowserType.EMAIL_CLIENT, RenderingEngine.GECKO, (String)null),
    THUNDERBIRD2(Manufacturer.MOZILLA, THUNDERBIRD, 120, "Thunderbird 2", new String[]{"Thunderbird/2"}, (String[])null, BrowserType.EMAIL_CLIENT, RenderingEngine.GECKO, (String)null),
    CAMINO(Manufacturer.OTHER, (Browser)null, 5, "Camino", new String[]{"Camino"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, "Camino\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?)"),
    CAMINO2(Manufacturer.OTHER, CAMINO, 17, "Camino 2", new String[]{"Camino/2"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, (String)null),
    FLOCK(Manufacturer.OTHER, (Browser)null, 4, "Flock", new String[]{"Flock"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, "Flock\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?)"),
    FIREFOX(Manufacturer.MOZILLA, (Browser)null, 10, "Firefox", new String[]{"Firefox"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, "Firefox\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"),
    FIREFOX3MOBILE(Manufacturer.MOZILLA, FIREFOX, 31, "Firefox 3 Mobile", new String[]{"Firefox/3.5 Maemo"}, (String[])null, BrowserType.MOBILE_BROWSER, RenderingEngine.GECKO, (String)null),
    FIREFOX4(Manufacturer.MOZILLA, FIREFOX, 40, "Firefox 4", new String[]{"Firefox/4"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, (String)null),
    FIREFOX3(Manufacturer.MOZILLA, FIREFOX, 30, "Firefox 3", new String[]{"Firefox/3"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, (String)null),
    FIREFOX2(Manufacturer.MOZILLA, FIREFOX, 20, "Firefox 2", new String[]{"Firefox/2"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, (String)null),
    FIREFOX1_5(Manufacturer.MOZILLA, FIREFOX, 15, "Firefox 1.5", new String[]{"Firefox/1.5"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, (String)null),
    SEAMONKEY(Manufacturer.OTHER, (Browser)null, 15, "SeaMonkey", new String[]{"SeaMonkey"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, "SeaMonkey\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?)"),
    BOT(Manufacturer.OTHER, (Browser)null, 12, "Robot/Spider", new String[]{"Googlebot", "bot", "spider", "crawler", "Feedfetcher", "Slurp", "Twiceler", "Nutch", "BecomeBot"}, (String[])null, BrowserType.ROBOT, RenderingEngine.OTHER, (String)null),
    MOZILLA(Manufacturer.MOZILLA, (Browser)null, 1, "Mozilla", new String[]{"Mozilla", "Moozilla"}, (String[])null, BrowserType.WEB_BROWSER, RenderingEngine.OTHER, (String)null),
    CFNETWORK(Manufacturer.OTHER, (Browser)null, 6, "CFNetwork", new String[]{"CFNetwork"}, (String[])null, BrowserType.UNKNOWN, RenderingEngine.OTHER, (String)null),
    EUDORA(Manufacturer.OTHER, (Browser)null, 7, "Eudora", new String[]{"Eudora", "EUDORA"}, (String[])null, BrowserType.EMAIL_CLIENT, RenderingEngine.OTHER, (String)null),
    POCOMAIL(Manufacturer.OTHER, (Browser)null, 8, "PocoMail", new String[]{"PocoMail"}, (String[])null, BrowserType.EMAIL_CLIENT, RenderingEngine.OTHER, (String)null),
    THEBAT(Manufacturer.OTHER, (Browser)null, 9, "The Bat!", new String[]{"The Bat"}, (String[])null, BrowserType.EMAIL_CLIENT, RenderingEngine.OTHER, (String)null),
    NETFRONT(Manufacturer.OTHER, (Browser)null, 10, "NetFront", new String[]{"NetFront"}, (String[])null, BrowserType.MOBILE_BROWSER, RenderingEngine.OTHER, (String)null),
    EVOLUTION(Manufacturer.OTHER, (Browser)null, 11, "Evolution", new String[]{"CamelHttpStream"}, (String[])null, BrowserType.EMAIL_CLIENT, RenderingEngine.OTHER, (String)null),
    LYNX(Manufacturer.OTHER, (Browser)null, 13, "Lynx", new String[]{"Lynx"}, (String[])null, BrowserType.TEXT_BROWSER, RenderingEngine.OTHER, "Lynx\\/(([0-9]+)\\.([\\d]+)\\.?([\\w-+]+)?\\.?([\\w-+]+)?)"),
    DOWNLOAD(Manufacturer.OTHER, (Browser)null, 16, "Downloading Tool", new String[]{"cURL", "wget"}, (String[])null, BrowserType.TEXT_BROWSER, RenderingEngine.OTHER, (String)null),
    UNKNOWN(Manufacturer.OTHER, (Browser)null, 14, "Unknown", new String[0], (String[])null, BrowserType.UNKNOWN, RenderingEngine.OTHER, (String)null);

    private final short id;
    private final String name;
    private final String[] aliases;
    private final String[] excludeList;
    private final BrowserType browserType;
    private final Manufacturer manufacturer;
    private final RenderingEngine renderingEngine;
    private final Browser parent;
    private List<Browser> children;
    private Pattern versionRegEx;

    private Browser(Manufacturer manufacturer, Browser parent, int versionId, String name, String[] aliases, String[] exclude, BrowserType browserType, RenderingEngine renderingEngine, String versionRegexString) {
        this.id = (short)((manufacturer.getId() << 8) + (byte)versionId);
        this.name = name;
        this.parent = parent;
        this.children = new ArrayList();
        if (this.parent != null) {
            this.parent.children.add(this);
        }

        this.aliases = aliases;
        this.excludeList = exclude;
        this.browserType = browserType;
        this.manufacturer = manufacturer;
        this.renderingEngine = renderingEngine;
        if (versionRegexString != null) {
            this.versionRegEx = Pattern.compile(versionRegexString);
        }

    }

    public short getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    private Pattern getVersionRegEx() {
        if (this.versionRegEx == null) {
            return this.getGroup() != this ? this.getGroup().getVersionRegEx() : null;
        } else {
            return this.versionRegEx;
        }
    }

    public Version getVersion(String userAgentString) {
        Pattern pattern = this.getVersionRegEx();
        if (userAgentString != null && pattern != null) {
            Matcher matcher = pattern.matcher(userAgentString);
            if (matcher.find()) {
                String fullVersionString = matcher.group(1);
                String majorVersion = matcher.group(2);
                String minorVersion = "0";
                if (matcher.groupCount() > 2) {
                    minorVersion = matcher.group(3);
                }

                return new Version(fullVersionString, majorVersion, minorVersion);
            }
        }

        return null;
    }

    public BrowserType getBrowserType() {
        return this.browserType;
    }

    public Manufacturer getManufacturer() {
        return this.manufacturer;
    }

    public RenderingEngine getRenderingEngine() {
        return this.renderingEngine;
    }

    public Browser getGroup() {
        return this.parent != null ? this.parent.getGroup() : this;
    }

    public boolean isInUserAgentString(String agentString) {
        String[] arr$ = this.aliases;
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String alias = arr$[i$];
            if (agentString.toLowerCase().indexOf(alias.toLowerCase()) != -1) {
                return true;
            }
        }

        return false;
    }

    private boolean containsExcludeToken(String agentString) {
        if (this.excludeList != null) {
            String[] arr$ = this.excludeList;
            int len$ = arr$.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String exclude = arr$[i$];
                if (agentString.toLowerCase().indexOf(exclude.toLowerCase()) != -1) {
                    return true;
                }
            }
        }

        return false;
    }

    private Browser checkUserAgent(String agentString) {
        if (this.isInUserAgentString(agentString)) {
            if (this.children.size() > 0) {
                Iterator i$ = this.children.iterator();

                while(i$.hasNext()) {
                    Browser childBrowser = (Browser)i$.next();
                    Browser match = childBrowser.checkUserAgent(agentString);
                    if (match != null) {
                        return match;
                    }
                }
            }

            if (!this.containsExcludeToken(agentString)) {
                return this;
            }
        }

        return null;
    }

    public static Browser parseUserAgentString(String agentString) {
        Browser[] arr$ = values();
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Browser browser = arr$[i$];
            if (browser.parent == null) {
                Browser match = browser.checkUserAgent(agentString);
                if (match != null) {
                    return match;
                }
            }
        }

        return UNKNOWN;
    }

    public static Browser valueOf(short id) {
        Browser[] arr$ = values();
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Browser browser = arr$[i$];
            if (browser.getId() == id) {
                return browser;
            }
        }

        throw new IllegalArgumentException("No enum const for id " + id);
    }
}
