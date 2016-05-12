package demo.kanban.contract.moscow.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.Document;

//@Configuration
public class CardTemplate {

    private @Value("#{spring.data.mongodb.uri}") String mongo;

//    @Bean
//    @Lazy
//    public CardDefaultTemplate configAsstDemoBeanParent() throws Exception {
//        CardDefaultTemplate demo = new CardDefaultTemplate();
//        demo.setDesc("sb");
//        demo.setName("template");
//        demo.setNumber("123");
//        demo.setTitle("abc");
//        mongoTemplate().save(demo);
//        mongoTemplate().findById("" , Object.class);
//        return demo;
//    }
//
//
//    @Bean
//    public MongoDbFactory mongoDbFactory() throws Exception {
//
//        // Mongo Client
//        MongoClient mongoClient = new MongoClient(new MongoClientURI(mongo));
//
//        // Mongo DB Factory
//        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(
//                mongoClient, "kanban");
//
//        return simpleMongoDbFactory;
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception {
//        return new MongoTemplate(mongoDbFactory());
//    }


    @Document(collection = "card_default_template")
    private class CardDefaultTemplate {
        private String name;
        private String title;
        private String number;
        private String desc;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
