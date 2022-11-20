package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {

    List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", studentGrades);
        return "grades";
    }

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String id) {
        GradeForm gradeForm = new GradeForm();

        if (id != null) {
            int index = findGradeIndexById(id);
            if (index != -1) {
                gradeForm = studentGrades.get(index).toGradeForm();
            }
        }

        model.addAttribute("gradeForm", gradeForm);
        return "form";
    }

    @PostMapping("/submitGrade")
    public String submitGrade(GradeForm gradeForm) {
        int index = findGradeIndexById(gradeForm.getId());
        if (index != -1) {
            studentGrades.set(index, gradeForm.toGrade());
        } else {
            studentGrades.add(gradeForm.toGrade());
        }

        if (gradeForm.isSubmittingAgain()) {
            return "redirect:/";
        } else {
            return "redirect:/grades";
        }
    }

    private int findGradeIndexById(String id) {
        for (int i = 0; i < studentGrades.size(); i++) {
            if (studentGrades.get(i).getId().equals(id)) {
                return i;
            }
        }

        return -1;
    }
}
