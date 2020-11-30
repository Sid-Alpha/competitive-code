package bfs.easy;

import utils.info.Question;

import java.util.HashMap;
import java.util.List;

@Question(url = "https://leetcode.com/problems/employee-importance/")
public class EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> hm = new HashMap<>();
        employees.forEach(s -> hm.put(s.id, s));

        return computeImportance(hm.get(id), hm);
    }

    private int computeImportance(Employee e, HashMap<Integer, Employee> hm) {
        int cnt = 0;
        for (int eNum : e.subordinates)
            cnt += computeImportance(hm.get(eNum), hm);

        return e.importance + cnt;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}
