package com.nectarmicrosystems.me.android.utilities;

import java.text.*;
import java.util.Date;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public abstract class Common {

    public static Date dateFromString(String dateString){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = null;

        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

}
