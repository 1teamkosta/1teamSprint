<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/quill@2.0.3/dist/quill.snow.css" rel="stylesheet" />

<div id="editor"> ${fix.content}</div> <br>


<script src="https://cdn.jsdelivr.net/npm/quill@2.0.3/dist/quill.js"></script>

<script>
const Size = Quill.import('attributors/style/size');

Size.whitelist = ['8px','9px','10px','11px','12px','13px','14px','15px','16px'];

Quill.register(Size, true);

const quill = new Quill('#editor', {
	  modules: {
	    toolbar: [
	      ['image'],
	      [{ 'font': [] },{ 'size': Size.whitelist }],
	      ['bold', 'italic', 'underline']
	      
	    ],
	  },
	  placeholder:'내용을 입력해 주세요. 어떤 표현이든 거리낌 없이 해도 되는 공간이 아닙니다.',
	  theme: 'snow', // or 'bubble'
	});
</script>
