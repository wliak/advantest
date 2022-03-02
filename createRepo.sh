rm -rf .git
git init
git add -A
git commit -m "first commit"
git branch -M main
echo 1 - Lee Hong
echo 2 - choo chin
echo 3 - Faiz
echo 4 - Khai Joe
echo 5 - leying
echo 6 - Yen Lee
echo 7 - Alex
echo Please select (1-7) :
read NUMB
git remote add origin https://github.com/wliak/labsCrossConnect${NUMB}.git
echo username - wliak
echo password - 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
git push -u origin main