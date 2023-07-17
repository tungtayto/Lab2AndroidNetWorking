<?php
    $rong = $_POST['rong'];
    $dai = $_POST['dai'];
    $chuvi = ($dai + $rong)*2;
    $dientich = $dai * $rong;
    echo "Chu Vi: " . $chuvi . "; Dien Tich: " . $dientich;
?> 