package com.ltp.workbook;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WorkbookController {

    List<Employee> staff = Arrays.asList(
        new Employee("Jim Halpert", 32, "Salesman"),
        new Employee("Andy Bernard", 38, "Salesman"),
        new Employee("Pam Beesly", 32, "Receptionist"),
        new Employee("Michael Scott", 49, "Regional Manager"),
        new Employee("Ryan Howard", 28, "Temp"),
        new Employee("Angela Martin", 35, "Accountant"),
        new Employee("Dwight Schrute", 37, "Assistant to the Regional Manager"),
        new Employee("Gabe Lewis", 38, "Resident Skeleton")
    );
    
    @GetMapping(value="/")
    public String getStaff(Model model) {
        model.addAttribute("staff", staff);
        return "staff";
    }
    
}
