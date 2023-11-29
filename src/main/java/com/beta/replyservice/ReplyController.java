package com.beta.replyservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;

@RestController
public class ReplyController {

	ReplyMessage replyMessage = new ReplyMessage("");


	@GetMapping("/reply")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}

	@GetMapping("/reply/{message}")
	public ReplyMessage replying(@PathVariable String message) {
		return new ReplyMessage(message);
	}


	// V2 mapping for the new api endpoint for the string reply
	@GetMapping("/v2/reply/{message}")
	public String replyingV2(@PathVariable String message) {
		String[] arrOfStr = message.split("-");
		String ruleSet = arrOfStr[0];
		String messageInput = arrOfStr[1];
		char [] rules = ruleSet.toCharArray();

		String result = messageInput;

		for (int i = 0; i < rules.length; i++) {
			if (rules[i] == '1'){
				result =  replyMessage.reverseString(result,1);
			} else if (rules[i] == '2') {
				result =  replyMessage.encode(message,2);
			} else return "Invalid Input";
		}
		return result;
	}

}