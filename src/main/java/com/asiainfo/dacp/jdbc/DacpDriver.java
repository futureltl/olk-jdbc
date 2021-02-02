package com.asiainfo.dacp.jdbc;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Strings.nullToEmpty;
import static io.prestosql.client.OkHttpUtil.userAgent;
import static java.lang.Integer.parseInt;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.prestosql.client.SocketChannelSocketFactory;
import io.prestosql.jdbc.PrestoDriver;
import okhttp3.OkHttpClient;

public class DacpDriver
        extends PrestoDriver
{
    public static final String DRIVER_NAME = "Dacp JDBC Driver";

    public static final String PRODUCT_NAME = "Dacp";

    public static final String DRIVER_VERSION;

    public static final int DRIVER_VERSION_MAJOR;

    public static final int DRIVER_VERSION_MINOR;

    public static final String DRIVER_PRODUCT_TAG = "dacp:";

    public static final String DRIVER_URL_START = "jdbc:" + DRIVER_PRODUCT_TAG;

    private final OkHttpClient httpClient = new OkHttpClient.Builder()
            .addInterceptor(userAgent(DRIVER_NAME + "/" + DRIVER_VERSION))
            .socketFactory(new SocketChannelSocketFactory())
            .build();

    static {
        String version = nullToEmpty(DacpDriver.class.getPackage().getSpecificationVersion());
        Matcher matcher = Pattern.compile("^(\\d+)(\\.(\\d+))?($|[.-])").matcher(version);
        if (!matcher.find()) {
            DRIVER_VERSION = "unknown";
            DRIVER_VERSION_MAJOR = 0;
            DRIVER_VERSION_MINOR = 0;
        }
        else {
            final int thirdGroup = 3;
            DRIVER_VERSION = version;
            DRIVER_VERSION_MAJOR = parseInt(matcher.group(1));
            DRIVER_VERSION_MINOR = parseInt(firstNonNull(matcher.group(thirdGroup), "0"));
        }

        try {
            DriverManager.registerDriver(new DacpDriver());
        }
        catch (SQLException e) {
            throw new RuntimeException("Fail to register Jdbc driver for dacp.");
        }
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException
    {
        return url.startsWith(DRIVER_URL_START);
    }
}
