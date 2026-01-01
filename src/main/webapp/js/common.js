// 二重送信防止用イベント
const buttons = document.querySelectorAll('.js--submit'); // クリックされるボタンを取得
const handInput = document.getElementById('js--hand-input'); // 送信するinput hiddenを取得
const form = document.querySelector('form'); // formを取得

buttons.forEach(button => {
  button.addEventListener('click', event => {
	// デフォルトのイベントを止める処理
    event.preventDefault();

    // クリックされたボタンの valueを hiddenの inputに代入
    handInput.value = button.value;

    // 全ボタンを無効化（連打防止）
    buttons.forEach(btn => btn.disabled = true);

    // 最後に formを submitする
    form.submit();
  });
});