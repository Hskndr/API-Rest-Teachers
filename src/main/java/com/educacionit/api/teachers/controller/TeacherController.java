package com.educacionit.api.teachers.controller;


import com.educacionit.api.teachers.beans.Message;
import com.educacionit.api.teachers.entities.Teacher;
import com.educacionit.api.teachers.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teachers")
public class TeacherController {

    @Autowired
    private ITeacherRepository dao;


    @RequestMapping (value="{id}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findTeacherById (@PathVariable("id") String id) {

        Teacher target = dao.findOne (id);

        if (target == null) {

            return ResponseEntity.status(404).body(new Message ("400", "Resource Teacher", String.format ("Teacher %s not found", id)));

        } else {

            return ResponseEntity.ok (target);
        }
    }

    @RequestMapping (value="/email/{val}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findTeacherByEmail (@PathVariable("val") String val) {

        Teacher target = dao.findTeacherByEmailLike (val);

        if (target == null) {

            return ResponseEntity.status(404).body(new Message ("400", "Resource Teacher", String.format ("Teacher %s not found", val)));

        } else {

            return ResponseEntity.ok (target);
        }
    }

    @RequestMapping (method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findAllTeachers () {

        List<Teacher> list = dao.findAll ();

        if (list.isEmpty ()) {

            return ResponseEntity.status(404).body(new Message ("400", "Resource Teacher", "List is empty, there are not Teachers."));

        } else {

            return ResponseEntity.ok (list);
        }
    }

    @RequestMapping (method = RequestMethod.POST)
    public ResponseEntity<?> save (@RequestBody @Validated Teacher data) {

        try {

            this.dao.save (data);

        } catch (Exception e) {

            return ResponseEntity.badRequest ().build ();
        }

        return ResponseEntity.noContent ().build ();
    }

    @RequestMapping (value="{id}", method = RequestMethod.PUT, consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> update (@PathVariable("id") String id, @RequestBody @Validated Teacher data) {

        try {

            if (!this.dao.exists (id)) {

                return ResponseEntity.status(404).body(new Message("400", "Resource Teacher", String.format ("Teacher %s not found", id)));
            }

            data.setId (id);
            this.dao.save (data);

        } catch (Exception e) {

            return ResponseEntity.badRequest ().build ();
        }

        return ResponseEntity.ok (data);
    }

    @RequestMapping (value="{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable("id") String id) {

        if (!this.dao.exists (id)) {

            return ResponseEntity.status(404).body(new Message ("400", "Resource Teacher", String.format ("Teacher %s not found", id)));

        } else {

            this.dao.delete (id);

            return ResponseEntity.noContent ().build ();
        }
    }
}
