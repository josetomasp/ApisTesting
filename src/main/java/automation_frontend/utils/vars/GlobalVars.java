package automation_frontend.utils.vars;

import automation_frontend.utils.enums.EGlobalVars;
import java.util.HashMap;
import java.util.Map;

public class GlobalVars {

    private static Map<EGlobalVars, String> dictionary = new HashMap<EGlobalVars, String>();

    /**
     * Get value from dictionary
     * @param  key  key from EGlobalsVars = Enum
     * @return      value from dictionary
     */
    public static String getVar(EGlobalVars key){
        return dictionary.get(key);
    }

    /**
     * Set value into dictionary
     * @param  key  key from EGlobalsVars = Enum
     * @param  value variable value
     */
    public static void setVar(EGlobalVars key, String value){
        dictionary.put(key, value);
    }
}
