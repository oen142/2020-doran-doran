package com.grasshouse.dorandoran.post.service;

import static com.grasshouse.dorandoran.fixture.LocationFixture.LOCATION;
import static com.grasshouse.dorandoran.fixture.MemberFixture.MEMBER;
import static org.assertj.core.api.Assertions.assertThat;

import com.grasshouse.dorandoran.member.domain.Member;
import com.grasshouse.dorandoran.member.repository.MemberRepository;
import com.grasshouse.dorandoran.post.service.dto.PostCreateRequest;
import com.grasshouse.dorandoran.post.service.dto.PostCreateResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("글이 작성된다.")
    @Test
    void createPostTest() {
        Member persistMember = memberRepository.save(MEMBER);
        PostCreateRequest postCreateRequest = PostCreateRequest.builder()
            .author(persistMember)
            .content("내용")
            .location(LOCATION)
            .build();

        PostCreateResponse createResponse = postService.createPost(postCreateRequest);
        assertThat(createResponse.getId()).isNotNull();
    }
}