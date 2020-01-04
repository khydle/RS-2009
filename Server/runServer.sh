echo "Start"
rm -rf org
cp -r ../CompiledServer/production/09Scape/org .
rm -rf plugin/
cp -r ../CompiledServer/production/09Scape/plugin/ .
echo "Done"
#java -server -cp ".:./bin;.:./data/libs/*" org.crandor.Server
