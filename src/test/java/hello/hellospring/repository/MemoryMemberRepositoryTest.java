package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
     MemoryMemberRepository repository = new MemoryMemberRepository();

     @AfterEach //각각의 메서드가 끝날 때마다 호출되는 메서드
     public void afterEach() {
          repository.clearStore();
     }

     @Test
     public void save() {
//given
          Member member = new Member();
          member.setName("spring");
//when
          repository.save(member);
//then
          Member result = repository.findById(member.getId()).orElse(null);
          assertThat(result).isEqualTo(member);
     }

     @Test
     public void findByName() {
//given
          Member member1 = new Member();
          member1.setName("spring1");
          repository.save(member1);
          Member member2 = new Member();
          member2.setName("spring2");
          repository.save(member2);
//when
          Member result1 = repository.findByName("spring2").orElse(null);
          //then
          assertThat(result1).isEqualTo(member2);
     }

     @Test
     public void findAll() {
          Member member1 = new Member();
          member1.setName("spring1");
          repository.save(member1);

          Member member2 = new Member();
          member2.setName("spring2");
          repository.save(member2);

          List<Member> result = repository.findAll();
          assertThat(result.size()).isEqualTo(2);
     }
}
