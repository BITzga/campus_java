package com.an.campus;

import com.an.campus.model.Topic;
import com.an.campus.repository.FollowerRepository;
import com.an.campus.repository.InvitationRepository;
import com.an.campus.repository.TopicRepository;
import com.an.campus.repository.UserRepository;
import com.an.campus.service.TopicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Random;

@SpringBootTest
@EnableMongoRepositories(basePackageClasses =InvitationRepository.class)
class LearningmongoApplicationTest {

    @Autowired
    InvitationRepository invitationRepository;
    @Autowired
    FollowerRepository fRepo;
    @Autowired
    UserRepository uRepo;
    @Autowired
    TopicRepository topicRepository;
    @Autowired
    TopicService topicService;
    private static Random random=new Random();
    private Topic createTopic(){
        int ranValue=random.nextInt(100);
        //var topic=new Topic(BigInteger.valueOf(ranValue),"content"+ranValue);
        return null;
    }
    @Test
    void testRepo(){
        var topics = new ArrayList<Topic>();
        for(int i=0;i<10;i++){
            var topic = createTopic();
            topics.add(topic);
            topicRepository.save(topic);
        }
        var findTopic = topicService.getTopics(0);
        System.out.println(findTopic);
        assert(topics==findTopic);


    }
}