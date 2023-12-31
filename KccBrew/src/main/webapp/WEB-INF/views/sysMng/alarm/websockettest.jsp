<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebSocket Tester</title>
<script
	src="https://cdn.jsdelivr.net/npm/sockjs-client@1.6.1/dist/sockjs.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
	var ping;
	var sockjs;

	jQuery(function($) {
		function writePing(message) {
			$('#pingOutput').append(message + '\n');
		}

		function writeStatus(message) {
			$("#statusOutput").val($("#statusOutput").val() + message + '\n');
		}

		function writeMessage(message) {
			$('#messageOutput').append(message + '\n')
		}

		$('#connect').click(function doConnect() {
			sockjs = new SockJS($("#target").val());

			sockjs.onopen = function(evt) {
				writeStatus("연결됨");

				var ping = setInterval(function() {
					if (sockjs != "undefined") {
						sockjs.send("핑(ping)");
					}
				}, 3000);
			};

			sockjs.onclose = function(evt) {
				writeStatus("연결이 해제됨");
			};

			sockjs.onmessage = function(evt) {
				if (evt.data === "핑(ping)") {
					writePing(evt.data);
				} else {
					writeMessage('수신 메시지: ' + evt.data);
				}
			};

			sockjs.onerror = function(evt) {
				onError(writeStatus('에러:' + evt.data))
			};
		});

		$('#disconnect').click(function() {
			if (typeof sockjs != 'undefined') {
				sockjs.close();
				sockjs = undefined;
			} else {
				alert("연결되지 않음.");
			}
		});

		$('#send').click(function() {
			if (typeof sockjs != 'undefined') {
				sockjs.send($('#message').val());
			} else {
				alert("연결되지 않음.");
			}
		});
	});
</script>
</head>
<body>
	<h2>SockJS 테스트</h2>
	대상:
	<input id="target" size="40" value="http://localhost:8080/echoHandler" />
	<br />
	<button id="connect">연결</button>
	<button id="disconnect">연결 해제</button>
	<br />
	<br />메시지:
	<input id="message" value="" />
	<button id="send">보내기</button>
	<br />
	<p>상태 출력:</p>
	<pre>
		<textarea id="statusOutput" rows="10" cols="50"></textarea>
	</pre>
	<p>메시지 출력:</p>
	<pre>
		<textarea id="messageOutput" rows="10" cols="50"></textarea>
	</pre>
	<p>핑(Ping) 출력:</p>
	<pre>
		<textarea id="pingOutput" rows="10" cols="50"></textarea>
	</pre>
</body>
</html>