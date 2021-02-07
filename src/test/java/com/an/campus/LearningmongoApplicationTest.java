package com.an.campus;

import com.an.campus.model.Comment;
import com.an.campus.model.Topic;
import com.an.campus.model.User;
import com.an.campus.repository.FollowerRepository;
import com.an.campus.repository.InvitationRepository;
import com.an.campus.repository.TopicRepository;
import com.an.campus.repository.UserRepository;
import com.an.campus.service.TopicService;
import org.junit.jupiter.api.Test;
import org.slf4j.IMarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@SpringBootTest

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
    private Topic createTopic(int minus){
        int ranValue=5555555;
        ArrayList<String> imgUrls = new ArrayList<>();
        ArrayList<Comment> comments = new ArrayList<>();
        ArrayList<BigInteger> likeList = new ArrayList<>();
        likeList.add(BigInteger.valueOf(211111));
        likeList.add(BigInteger.valueOf(111111));
        Comment comment1 = new Comment(
                BigInteger.valueOf(1234),
                BigInteger.valueOf(1000000000),
                BigInteger.valueOf(1234),
                BigInteger.valueOf(1234),
                "一级评论",
                "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
                50,
                new Date(),new ArrayList<>());
        Comment comment2 = new Comment(
                BigInteger.valueOf(4567),
                BigInteger.valueOf(1000000000),
                BigInteger.valueOf(1234),
                BigInteger.valueOf(1234),
                "二级评论",
                "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
                50,
                new Date(),new ArrayList<>());
        comment1.addComment(comment2);
        comments.add(comment1);

        imgUrls.add("https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg");
        imgUrls.add("https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg");
        var topic=new Topic(BigInteger.valueOf(ranValue+minus),BigInteger.valueOf(123),imgUrls,comments,
                "南校区篮球场","约球",50,20,new Date(),likeList);

        return topic;
    }
    @Test
    void testRepo(){
//        var topics = new ArrayList<Topic>();
//        for(int i=0;i<10;i++){
//            var topic = createTopic(i);
//            topics.add(topic);
//            topicRepository.save(topic);
//        }
//        System.out.println(topics);
//        System.out.println(topicRepository.findById(BigInteger.valueOf(1000000000)));
////        System.out.println(topicRepository.findById(BigInteger.valueOf(1000000001)));
//        uRepo.save(new User(BigInteger.valueOf(1111),"pwd"));
//        uRepo.save(new User(BigInteger.valueOf(1112),"123"));
    }
}