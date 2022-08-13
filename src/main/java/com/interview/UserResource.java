package com.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserResource {
    /*
    Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID.

The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

Example:
logs1 = {
{"58523", "user_1", "resource_1"},
{"62314", "user_2", "resource_2"},
{"54001", "user_1", "resource_3"},
{"200", "user_6", "resource_5"},
{"215", "user_6", "resource_4"},
{"54060", "user_2", "resource_3"},
{"53760", "user_3", "resource_3"},
{"58522", "user_22", "resource_1"},
{"53651", "user_5", "resource_3"},
{"2", "user_6", "resource_1"},
{"100", "user_6", "resource_6"},
{"400", "user_7", "resource_2"},
{"100", "user_8", "resource_6"},
{"54359", "user_1", "resource_3"},
}

Example 2:
logs2 = [
["300", "user_1", "resource_3"],
["599", "user_1", "resource_3"],
["900", "user_1", "resource_3"],
["1199", "user_1", "resource_3"],
["1200", "user_1", "resource_3"],
["1201", "user_1", "resource_3"],
["1202", "user_1", "resource_3"]
]

Example 3:
logs3 = [
["300", "user_10", "resource_5"]
]

1st question was to write a function that returned the when the users 
initially accessed a resource and when they last accessed a resource in the form of: { user_1 ["300", "1201"], user_2:...}
     */
    
    public static void main(String[] args) {
        String[][] logs2 = {
{"300", "user_1", "resource_3"},
{"599", "user_1", "resource_3"},
{"900", "user_1", "resource_3"},
{"1199", "user_1", "resource_3"},
{"1200", "user_1", "resource_3"},
{"1201", "user_1", "resource_3"},
{"1202", "user_1", "resource_3"}
};
        Map<String, List<String>> r = resourceMap(logs2, "resource_3");
        for(String key:r.keySet()) {
            System.out.println(key + ", " + r.get(key));
        }

        String[][] logs1 = {
                {"58523", "user_1", "resource_1"},
                {"62314", "user_2", "resource_2"},
                {"54001", "user_1", "resource_3"},
                {"200", "user_6", "resource_5"},
                {"215", "user_6", "resource_4"},
                {"54060", "user_2", "resource_3"},
                {"53760", "user_3", "resource_3"},
                {"58522", "user_22", "resource_1"},
                {"53651", "user_5", "resource_3"},
                {"2", "user_6", "resource_1"},
                {"100", "user_6", "resource_6"},
                {"400", "user_7", "resource_2"},
                {"100", "user_8", "resource_6"},
                {"54359", "user_1", "resource_3"},
        };
        System.out.println();

        r = resourceMap(logs1, "resource_3");
        for(String key:r.keySet()) {
            System.out.println(key + ", " + r.get(key));
        }
    }
    
    public static Map<String, List<String>> resourceMap(String[][] logs, String resource) {
        Map<String, List<String>> result = new HashMap<>();
        for(int i=0; i < logs.length; i++) {
            
            String[] currentLog = logs[i];
            if (!currentLog[2].equals(resource)) {
                continue;
            }
            List<String> userData = result.getOrDefault(currentLog[1], new ArrayList<>());
            userData.add(currentLog[0]);
            result.put(currentLog[1], userData);
        }
        for(String key:result.keySet()) {
            List<String> userData = result.get(key);
            userData.sort((a,b) -> {
                int i = Integer.parseInt(a);
                int j = Integer.parseInt(b);
                return i-j;
            });
            
            //userData = new ArrayList<>({userData.get(0), userData.get(userData.size()-1)});
            List<String> userData1 = new ArrayList<>();
            userData1.add(userData.get(0));
            userData1.add(userData.get(userData.size()-1));
            result.put(key, userData1);
        }
        return result;
    }
}
