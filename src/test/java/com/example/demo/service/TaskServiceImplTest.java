package com.example.demo.service;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.example.demo.entity.Task;

//Junit5上でSpring TestContext Frameworkを利用することを示す
@SpringJUnitConfig
//毎回サーバ起動
@SpringBootTest
//application-unit.yml(src/test/resources)のファイル名-unitとunitを対応（DBの設定を読み込む）
@ActiveProfiles("unit")
@DisplayName("TaskServiceImplの結合テスト")
class TaskServiceImplTest {

	@Autowired
	private TaskService taskService;

	@Test
	@DisplayName("タスクが取得できない場合のテスト")
	void testGetTaskFormReturnNull() {

		try {
			Optional<Task> task = taskService.getTask(0);
		} catch (TaskNotFoundException e) {
			Assertions.assertEquals(e.getMessage(), "指定されたタスクが存在しません");
		}
	}

	@Test //order byがある場合は順序の確認をすることがある
	@DisplayName("全件検索のテスト")
	void testFindAllCheckCount() {
		//全件取得
		List<Task> task = taskService.findAll();
		//Taskテーブルに入っている2件が取得できているか確認
		assertThat(task.size(), is(2));
	}

	@Test
	@DisplayName("1件のタスクが取得できた場合のテスト")
	void testGetTaskFormReturnOne() {
		//idが1のTaskを取得
		Optional<Task> taskOpt = taskService.getTask(1);
		//取得できたことを確認
		assertThat(taskOpt.get().getTitle(), is("JUnitを学習"));
	}

}
