package springrest.exam.controller;

import java.util.List;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springrest.exam.domain.ComicActor;
import springrest.exam.domain.ComicActorModel;
import java.util.ArrayList;
@RestController
public class HateoasRestController {
  @GetMapping("/all")
  public ResponseEntity<List<ComicActorModel>> collection() {
    List<ComicActorModel> list = new ArrayList<>();
    ComicActorModel cm1 = new ComicActorModel("둘리");
    ComicActorModel cm2 = new ComicActorModel("또치");
    ComicActorModel cm3 = new ComicActorModel("도우너");
    cm1.add(Link.of("http://192.168.3.123:8088/dooly"));
    cm2.add(Link.of("http://192.168.3.123:8088/ddochi"));
    cm3.add(Link.of("http://192.168.3.123:8088/dauner"));

    list.add(cm1);
    list.add(cm2);
    list.add(cm3);

    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/dooly")
  public ResponseEntity<ComicActor> getDooly(){
    ComicActor act = ComicActor.builder().name("둘리").addr("쌍문동").image("dooly.jpg").build();
    return ResponseEntity.ok().body(act);
  }

  @GetMapping("/ddochi")
  public ResponseEntity<ComicActor> getDdochi() {
    ComicActor act = ComicActor.builder().name("또치").addr("아프리카").image("ddochi.jpg").build();
    return ResponseEntity.ok().body(act);
  }

  @GetMapping("/dauner")
  public ResponseEntity<ComicActor> getDauner() {
    ComicActor act = ComicActor.builder().name("도우너").addr("깐따삐아").image("dauner.png").build();
    return ResponseEntity.ok().body(act);
  }
}
