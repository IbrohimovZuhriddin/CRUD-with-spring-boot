package zuhriddinscode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zuhriddinscode.EmailRequest;
import zuhriddinscode.dto.IconDTO;
import zuhriddinscode.email.EmailService;
import zuhriddinscode.service.ToDoService;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class IconController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private ToDoService toDoService;

    @GetMapping("findAll")
    private List<IconDTO> findAll() {
        return toDoService.findAll();
    }

    @GetMapping("findByIsDoneAll") // bazadan id si bo'yicha ajratib olish
    private List<IconDTO> findByIsDoneAll(@RequestParam boolean isActive ) {
        return toDoService.findBYIsDoneAll(isActive);
    }

    @PostMapping("/addText")  // create qilish bazaga yozish
    private ResponseEntity<String> addText(@RequestBody IconDTO iconDTO){
       String response = toDoService.addText(iconDTO);
       return ResponseEntity.ok(response);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateIcon (@PathVariable Long id, @RequestBody IconDTO iconDTO){
    toDoService.update( id, iconDTO);
    return (ResponseEntity) ResponseEntity.status(HttpStatus.OK);
    }

    @GetMapping("/pagination/")
    public ResponseEntity<Page<IconDTO>> getAllToDos(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "1000") int size) {
        Pageable pageable = PageRequest.of(page, size);// 1 ta pageda nechta obyekt chiqarilishi

        Page<IconDTO> toDosPage = toDoService.getAllToDos(pageable);
        return ResponseEntity.ok(toDosPage);
    }

    @PostMapping("/send-email")
    public void sendEmail(@RequestBody EmailRequest request) {
        emailService.send(request.getTo(), request.getSubject(), request.getText());
    }


//    @PutMapping("/newUpdate/{id}")
//    public ResponseEntity<String>  newUpdate(@PathVariable Long id, @RequestBody IconDTO iconDTO ){
//       String response =  toDoService.NewUpdate(iconDTO);
//        return response;
//    }

//    @DeleteMapping("/delete/{iconId}")
//    private  ResponseEntity<Void> deleteById(@PathVariable("iconId") Long iconId ){  // nima uchun Long, int emas
//        toDoService.deleteById(iconId);
//        return ResponseEntity.ok().build();
//    }

//    @GetMapping("findAll")
//    public List<IconDTO> findAlltest(@RequestParam IconDTO icon) {
//        return toDoService.findAll();
//    }  --------------xato-- requestparam shartmas bu yerda chunki hammasini olishda qanday qilib yana cheklov kiritish mumkin


}