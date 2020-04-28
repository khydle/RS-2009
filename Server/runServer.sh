rm -rf org
cp -r ../CompiledServer/production/RS-2009/org .
rm -rf plugin/
cp -r ../CompiledServer/production/RS-2009/plugin/ .
java -server -cp ".:./bin;.:./data/libs/*" -Xms256m -Xmx1280m org.crandor.Server
