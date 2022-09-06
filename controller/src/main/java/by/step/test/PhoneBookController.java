package by.step.test;
import by.step.test.service.PhoneBookService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/phonebooks")
public class PhoneBookController {

    private PhoneBookService phoneBookService;

    public PhoneBookController(PhoneBookService phoneBookService) {

        this.phoneBookService = phoneBookService;
    }

    @GetMapping("/{name}")
    String name(@PathVariable ("name") String name) {
        return name + " Vasya";
    }

    @GetMapping("/getSurname")
    String surname(@RequestParam String surname) {
        return surname + " Ivanov";
    }

    @GetMapping("/phoneNumber")
    String getPhoneNumber(@RequestParam String phoneNumber) {
        return phoneNumber + " Vasya";
    }

    @GetMapping("/phoneBook")
    String phoneBook  (@RequestParam  String phoneBook){
        return phoneBook;
    }


}
