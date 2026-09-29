<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
			<div class="contentFunction">
				<input type="file" id="fileInput" >
				 <select>
	              <option value="0">기본서체</option>
	              <option value="1">궁서체</option>
	              <option value="2">고딕</option>
	              <option value="3">나눔글꼴</option>
	            </select>
	            <select>
	              <option value="4">10px</option>
	              <option value="5">11px</option>
	              <option value="6">12px</option>
	              <option value="7">13px</option>
	            </select>
	            <span class="BIU">
			    <button class="bold">B</button>
			    <button class="italic">I</button>
			    <button class="underline" >U</button>
			    </span>
            </div>
			<textarea class="inputContent" placeholder=" 내용을 입력해 주세요. 어떤 표현이든 거리낌 없이 해도 되는 공간이 아닙니다."></textarea>
			<button class="submitBtn">등록</button>