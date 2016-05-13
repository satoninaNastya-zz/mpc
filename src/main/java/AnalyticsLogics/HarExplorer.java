package AnalyticsLogics;


import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HarExplorer {


    private static List<String> getAllJoytikaAnalyticsActions(@NotNull final Har har) {
        String url;
        List<HarEntry> harEntries = har.getLog().getEntries();
        List<String> analyticsActionUrls = new ArrayList<String>();
        for (HarEntry he : harEntries) {
            url = he.getRequest().getUrl();

            if (url.contains("stats.joytika.com")) {
                analyticsActionUrls.add(url);
            }
        }

        return analyticsActionUrls;
    }

    private static boolean checkParameter(@NotNull final String actionUrl, Map<String, String> parameters) {
        for (String nameParameter : parameters.keySet()) {
            if (!(actionUrl.contains(nameParameter + "=" + parameters.get(nameParameter)) || actionUrl.contains("[" + nameParameter + "]=" + parameters.get(nameParameter)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean searchActionWithParameters(@NotNull Har har, @Nullable Map<String, String> parameters) {

        if (parameters == null) {
            return false;
        }
        List<String> analyticsActionUrls = getAllJoytikaAnalyticsActions(har);
        for (String actionUrl : analyticsActionUrls) {
            System.out.println(actionUrl);
            if (checkParameter(actionUrl, parameters)) {
                return true;
            }
        }

        return false;
    }


}
