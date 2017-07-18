package com.example.wind.osnews.Bean;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * Created by wind on 17-7-18.
 */

public class QuestionDetailBean extends BasePageBean<QuestionDetailBean.ResultBean> {

    /**
     * code : 1
     * message : SUCCESS
     * notice : {"like":0,"review":0,"letter":0,"mention":0,"fans":0}
     * result : {"author":"彭博","authorId":89964,"authorPortrait":"https://static.oschina.net/uploads/user/44/89964_50.jpg?t=1387866654000","body":"在许多Java工程中，经常会看到带有程序自定义参数调用Java命令的包装shell脚本。例如， \n<pre class=\"brush:shell; toolbar: true; auto-links: false;\">$ANT_HOME/bin/ant, $GROOVY_HOME/bin/groovy<\/pre>，甚至在我们的TimeMachine Scheduler程序中也能见到 \n<pre class=\"brush:shell; toolbar: true; auto-links: false;\">$TIMEMACHINE_HOME/bin/scheduler.sh<\/pre> \n<p>编写这些包装脚本很无聊而且容易出错。大多数的问题来自为程序设置正确的classpath。如果你正在为一个公司开发内部项目的话，那么你有可能远离纠结的路径以及环境变量问题。但是对于开源项目，人们需要使包装更加灵活和通用。大多数甚至提供了.bat版本。Windows DOS确实是个野蛮且被限制的终端而不能很好的满足你项目脚本需求。因此，我常鼓励别人尽量还是多使用Cygwi。至少它具备一个真实的bash shell。其他常见的问题就是这些包装很快就会失去控制而且在你的项目各处都会出现很多冗余脚本。<\/p> \n<p><b>run-java包装脚本介绍<\/b><\/p> \n<p>如果你看到 $TIMEMACHINE_HOME/bin/scheduler.sh 的代码,你会看到它其实是在同目录下循环调用run-java脚本。<\/p> \n<pre class=\"brush:shell; toolbar: true; auto-links: false;\">DIR=$(dirname $0)\nSCHEDULER_HOME=$DIR/..\n$DIR/run-java -Dscheduler.home=\"$SCHEDULER_HOME\" timemachine.scheduler.tool.SchedulerServer \"$@\"<\/pre> \n<p> 正如你看到的，我们的 run-java 可以使用 -D 选项，不仅这样，它同样也能使用 -cp 选项！而且，你还能在main class<b>后面<\/b>指定这些选项！这样能够使得run-java被其他的脚本包装,并且仍旧能够添加额外的系统属性以及classpath。<\/p> \n<p>例如，TimeMachine 附带了 Groovy 库，所以你可以简单的像这样调用<\/p> \n<pre class=\"brush:shell; toolbar: true; auto-links: false;\">groovy：$TIMEMACHINE_HOME/bin/run-java groovy.ui.GroovyMain test.groovy<\/pre> \n<p> ，而不用再次下载整个分支。<\/p> \n<p>你可以很方便地在任何目录下使用，它确认自己的目录然后可以自动加载lib目录下的任何jar包。现在如果你想要附加更多的jar包来运行Groovy的话，可以如下使用 -cp 选项：<\/p> \n<pre class=\"brush:shell; toolbar: true; auto-links: false;\">$TIMEMACHINE_HOME/bin/run-java -cp \"$HOME/apps/my-app/lib/*\" groovy.ui.GroovyMain test.groovy<\/pre> \n<p> 通常如果你设置java classpath不够小心时会经常导致错误，但是使用 run-java 可以预先运行一次：<\/p> \n<pre class=\"brush:shell; toolbar: true; auto-links: false;\">RUN_JAVA_DRY=1 $TIMEMACHINE_HOME/bin/run-java -cp \"$HOME/apps/my-app/lib/*\" groovy.ui.GroovyMain test.groovy<\/pre> \n<p> 你只需在命令提示行中运行上面一整行代码即可。它将输出完整的附带所有选项和参数的java命令。<\/p> \n<p>run-script还包含很多其它的选项，你可以通过查看其注释了解。当前的脚本能够在任何的Linux bash和Windows Cygwin中运行。<\/p> \n<p><b>在开发中通过Maven使用 run-java<\/b><\/p> \n<p>根据上面提到的示例，假设项目发布结构如下：<\/p> \n<pre><code>$TIMEMACHINE_HOME\n  +- bin/run-java\n  +- lib/*.jar<\/code><\/pre> \n<p> 但是在开发过程中目录会是怎样呢？一个常见的用例便是：你希望能够运行target/classes下最新编译的代码而不是将整个项目打包或者发布。你同样可以在此种情况下使用 run-java 。首先，简单的将 bin/run-java 添加进你的项目，然后运行<\/p> \n<pre class=\"brush:shell; toolbar: true; auto-links: false;\">mvn compile dependency:copy-dependencies<\/pre> \n<p> 将会在target/dependency下生成所有的jar文件。就只需要做这些。run-java将自动的检测这些目录，并为你的main class创建正确的classpath。<\/p> \n<p>如果你使用Eclipse来开发，那么你的target/classes目录将总是在更新的，run-java便能成为你项目开发中的瑰宝。<\/p> \n<p><b>获取 run-java 包装脚本<\/b><\/p> \n<pre class=\"brush:shell; toolbar: true; auto-links: false;\">#!/usr/bin/env bash\n#\n# Copyright 2012 Zemian Deng\n# \n# Licensed under the Apache License, Version 2.0 (the \"License\");\n# you may not use this file except in compliance with the License.\n# You may obtain a copy of the License at\n# \n#    http://www.apache.org/licenses/LICENSE-2.0\n# \n# Unless required by applicable law or agreed to in writing, software\n# distributed under the License is distributed on an \"AS IS\" BASIS,\n# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n# See the License for the specific language governing permissions and\n# limitations under the License.\n\n# A wrapper script that run any Java6 application in unix/cygwin env.\n#\n# This script is assumed to be located in an application's \"bin\" directory. It will\n# auto resolve any symbolic link and always run in relative to this application \n# directory (which is one parent up from the script.) Therefore, this script can be\n# run any where in the file system and it will still reference this application \n# directory.\n#\n# This script will by default auto setup a Java classpath that picks up any \"config\"\n# and \"lib\" directories under the application directory. It also will also add a \n# any typical Maven project output directories such as \"target/test-classes\", \n# \"target/classes\", and \"target/dependency\" into classpath. This can be disable by \n# setting RUN_JAVA_NO_PARSE=1.\n#\n# If the \"Default parameters\" section bellow doesn't match to user's env, then user\n# may override these variables in their terminal session or preset them in shell's \n# profile startup script. The values of all path should be in cygwin/unix path, \n# and this script will auto convert them into Windows path where is needed.\n#\n# User may customize the Java classpath by setting RUN_JAVA_CP, which will prefix to existing\n# classpath, or use the \"-cp\" option, which will postfix to existing classpath.\n# \n# Usage:\n#   run-java [java_opts] &lt;java_main_class&gt; [-cp /more/classpath] [-Dsysprop=value]\n#\n# Example:\n#   run-java example.Hello\n#   run-java example.Hello -Dname=World\n#   run-java org.junit.runner.JUnitCore example.HelloTest -cp \"C:\\apps\\lib\\junit4.8.2\\*\"\n#\n# Created by: Zemian Deng 03/09/2012\n\n# This run script dir (resolve to absolute path)\nSCRIPT_DIR=$(cd $(dirname $0) &amp;&amp; pwd)    # This dir is where this script live.\nAPP_DIR=$(cd $SCRIPT_DIR/.. &amp;&amp; pwd)      # Assume the application dir is one level up from script dir.\n\n# Default parameters\nJAVA_HOME=${JAVA_HOME:=/apps/jdk}        # This is the home directory of Java development kit.\nRUN_JAVA_CP=${RUN_JAVA_CP:=$CLASSPATH}     # A classpath prefix before -classpath option, default to $CLASSPATH\nRUN_JAVA_OPTS=${RUN_JAVA_OPTS:=}           # Java options (-Xmx512m -XX:MaxPermSize=128m etc)\nRUN_JAVA_DEBUG=${RUN_JAVA_DEBUG:=}         # If not empty, print the full java command line before executing it.\nRUN_JAVA_NO_PARSE=${RUN_JAVA_NO_PARSE:=}   # If not empty, skip the auto parsing of -D and -cp options from script arguments.\nRUN_JAVA_NO_AUTOCP=${RUN_JAVA_NO_AUTOCP:=} # If not empty, do not auto setup Java classpath\nRUN_JAVA_DRY=${RUN_JAVA_DRY:=}             # If not empty, do not exec Java command, but just print\n\n# OS specific support.  $var _must_ be set to either true or false.\nCYGWIN=false;\ncase \"`uname`\" in\n  CYGWIN*) CYGWIN=true ;;\nesac\n\n# Define where is the java executable is\nJAVA_CMD=java\nif [ -d \"$JAVA_HOME\" ]; then\n        JAVA_CMD=\"$JAVA_HOME/bin/java\"\nfi\n\n# Auto setup applciation's Java Classpath (only if they exists)\nif [ -z \"$RUN_JAVA_NO_AUTOCP\" ]; then\n        if $CYGWIN; then\n                # Provide Windows directory conversion\n                JAVA_HOME_WIN=$(cygpath -aw \"$JAVA_HOME\")\n                APP_DIR_WIN=$(cygpath -aw \"$APP_DIR\")\n\n                if [ -d \"$APP_DIR_WIN\\config\" ]; then RUN_JAVA_CP=\"$RUN_JAVA_CP;$APP_DIR_WIN\\config\" ; fi\n                if [ -d \"$APP_DIR_WIN\\target\\test-classes\" ]; then RUN_JAVA_CP=\"$RUN_JAVA_CP;$APP_DIR_WIN\\target\\test-classes\" ; fi\n                if [ -d \"$APP_DIR_WIN\\target\\classes\" ]; then RUN_JAVA_CP=\"$RUN_JAVA_CP;$APP_DIR_WIN\\target\\classes\" ; fi\n                if [ -d \"$APP_DIR_WIN\\target\\dependency\" ]; then RUN_JAVA_CP=\"$RUN_JAVA_CP;$APP_DIR_WIN\\target\\dependency\\*\" ; fi\n                if [ -d \"$APP_DIR_WIN\\lib\" ]; then RUN_JAVA_CP=\"$RUN_JAVA_CP;$APP_DIR_WIN\\lib\\*\" ; fi\n        else\n                if [ -d \"$APP_DIR/config\" ]; then RUN_JAVA_CP=\"$RUN_JAVA_CP:$APP_DIR/config\" ; fi\n                if [ -d \"$APP_DIR/target/test-classes\" ]; then RUN_JAVA_CP=\"$RUN_JAVA_CP:$APP_DIR/target/test-classes\" ; fi\n                if [ -d \"$APP_DIR/target/classes\" ]; then RUN_JAVA_CP=\"$RUN_JAVA_CP:$APP_DIR/target/classes\" ; fi\n                if [ -d \"$APP_DIR/target/dependency\" ]; then RUN_JAVA_CP=\"$RUN_JAVA_CP:$APP_DIR/target/dependency/*\" ; fi\n                if [ -d \"$APP_DIR/lib\" ]; then RUN_JAVA_CP=\"$RUN_JAVA_CP:$APP_DIR/lib/*\" ; fi\n        fi\nfi\n\n# Parse addition \"-cp\" and \"-D\" after the Java main class from script arguments\n#   This is done for convenient sake so users do not have to export RUN_JAVA_CP and RUN_JAVA_OPTS\n#   saparately, but now they can pass into end of this run-java script instead.\n#   This can be disable by setting RUN_JAVA_NO_PARSE=1.\nif [ -z \"$RUN_JAVA_NO_PARSE\" ]; then    \n        # Prepare variables for parsing\n        FOUND_CP=\n        declare -a NEW_ARGS\n        IDX=0\n        \n        # Parse all arguments and look for \"-cp\" and \"-D\"\n        for ARG in \"$@\"; do\n                if [[ -n $FOUND_CP ]]; then     \n                        if [ \"$OS\" = \"Windows_NT\" ]; then\n                                # Can't use cygpath here, because cygpath will auto expand \"*\", which we do not\n                                # want. User will just have to use OS path when specifying \"-cp\" option.        \n                                #ARG=$(cygpath -w -a $ARG)\n                                RUN_JAVA_CP=\"$RUN_JAVA_CP;$ARG\"\n                        else\n                                RUN_JAVA_CP=\"$RUN_JAVA_CP:$ARG\"\n                        fi\n                        FOUND_CP=\n                else\n                        case $ARG in\n                        '-cp')\n                                FOUND_CP=1\n                                ;;\n                        '-D'*)\n                                RUN_JAVA_OPTS=\"$RUN_JAVA_OPTS $ARG\"\n                                ;;\n                        *)\n                                NEW_ARGS[$IDX]=\"$ARG\"\n                                let IDX=$IDX+1\n                                ;;\n                        esac\n                fi\n        done\n                \n        # Display full Java command.\n        if [ -n \"$RUN_JAVA_DEBUG\" ] || [ -n \"$RUN_JAVA_DRY\" ]; then\n                echo \"$JAVA_CMD\" $RUN_JAVA_OPTS -cp \"$RUN_JAVA_CP\" \"${NEW_ARGS[@]}\"\n        fi\n        \n        # Run Java Main class using parsed variables\n        if [ -z \"$RUN_JAVA_DRY\" ]; then\n                \"$JAVA_CMD\" $RUN_JAVA_OPTS -cp \"$RUN_JAVA_CP\" \"${NEW_ARGS[@]}\"\n        fi\nelse\n        # Display full Java command.\n        if [ -n \"$RUN_JAVA_DEBUG\" ] || [ -n \"$RUN_JAVA_DRY\" ]; then\n                echo \"$JAVA_CMD\" $RUN_JAVA_OPTS -cp \"$RUN_JAVA_CP\" \"$@\"\n        fi\n        \n        # Run Java Main class\n        if [ -z \"$RUN_JAVA_DRY\" ]; then\n                \"$JAVA_CMD\" $RUN_JAVA_OPTS -cp \"$RUN_JAVA_CP\" \"$@\"\n        fi\nfi<\/pre> \n<p> <\/p> \n<a target=\"_blank\" href=\"http://saltnlight5.blogspot.tw/2012/08/a-better-java-shell-script-wrapper.html\" rel=\"nofollow\">原文链接 <\/a>/ \n<a target=\"_blank\" href=\"http://www.oschina.net\" rel=\"nofollow\">OSChina.NET 原创翻译<\/a> \n<br>","commentCount":6,"favorite":false,"href":"https://www.oschina.net/question/89964_64993","id":64993,"pubDate":"2012-08-14 17:54:33","tags":["Java","OSCHINA原创翻译"],"title":"一个更好Java Shell 脚本包装","viewCount":4994}
     * time : 2017-07-18 22:58:33
     */

    private int code;
    private String message;
    private NoticeBean notice;
    private ResultBean result;
    private String time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NoticeBean getNotice() {
        return notice;
    }

    public void setNotice(NoticeBean notice) {
        this.notice = notice;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public List getItemDatas() {
        return getItemDatas();
    }

    public static class NoticeBean {
        /**
         * like : 0
         * review : 0
         * letter : 0
         * mention : 0
         * fans : 0
         */

        private int like;
        private int review;
        private int letter;
        private int mention;
        private int fans;

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }

        public int getReview() {
            return review;
        }

        public void setReview(int review) {
            this.review = review;
        }

        public int getLetter() {
            return letter;
        }

        public void setLetter(int letter) {
            this.letter = letter;
        }

        public int getMention() {
            return mention;
        }

        public void setMention(int mention) {
            this.mention = mention;
        }

        public int getFans() {
            return fans;
        }

        public void setFans(int fans) {
            this.fans = fans;
        }
    }

    public static class ResultBean {
        /**
         * author : 彭博
         * authorId : 89964
         * authorPortrait : https://static.oschina.net/uploads/user/44/89964_50.jpg?t=1387866654000
         * body : 在许多Java工程中，经常会看到带有程序自定义参数调用Java命令的包装shell脚本。例如，
         <pre class="brush:shell; toolbar: true; auto-links: false;">$ANT_HOME/bin/ant, $GROOVY_HOME/bin/groovy</pre>，甚至在我们的TimeMachine Scheduler程序中也能见到
         <pre class="brush:shell; toolbar: true; auto-links: false;">$TIMEMACHINE_HOME/bin/scheduler.sh</pre>
         <p>编写这些包装脚本很无聊而且容易出错。大多数的问题来自为程序设置正确的classpath。如果你正在为一个公司开发内部项目的话，那么你有可能远离纠结的路径以及环境变量问题。但是对于开源项目，人们需要使包装更加灵活和通用。大多数甚至提供了.bat版本。Windows DOS确实是个野蛮且被限制的终端而不能很好的满足你项目脚本需求。因此，我常鼓励别人尽量还是多使用Cygwi。至少它具备一个真实的bash shell。其他常见的问题就是这些包装很快就会失去控制而且在你的项目各处都会出现很多冗余脚本。</p>
         <p><b>run-java包装脚本介绍</b></p>
         <p>如果你看到 $TIMEMACHINE_HOME/bin/scheduler.sh 的代码,你会看到它其实是在同目录下循环调用run-java脚本。</p>
         <pre class="brush:shell; toolbar: true; auto-links: false;">DIR=$(dirname $0)
         SCHEDULER_HOME=$DIR/..
         $DIR/run-java -Dscheduler.home="$SCHEDULER_HOME" timemachine.scheduler.tool.SchedulerServer "$@"</pre>
         <p> 正如你看到的，我们的 run-java 可以使用 -D 选项，不仅这样，它同样也能使用 -cp 选项！而且，你还能在main class<b>后面</b>指定这些选项！这样能够使得run-java被其他的脚本包装,并且仍旧能够添加额外的系统属性以及classpath。</p>
         <p>例如，TimeMachine 附带了 Groovy 库，所以你可以简单的像这样调用</p>
         <pre class="brush:shell; toolbar: true; auto-links: false;">groovy：$TIMEMACHINE_HOME/bin/run-java groovy.ui.GroovyMain test.groovy</pre>
         <p> ，而不用再次下载整个分支。</p>
         <p>你可以很方便地在任何目录下使用，它确认自己的目录然后可以自动加载lib目录下的任何jar包。现在如果你想要附加更多的jar包来运行Groovy的话，可以如下使用 -cp 选项：</p>
         <pre class="brush:shell; toolbar: true; auto-links: false;">$TIMEMACHINE_HOME/bin/run-java -cp "$HOME/apps/my-app/lib/*" groovy.ui.GroovyMain test.groovy</pre>
         <p> 通常如果你设置java classpath不够小心时会经常导致错误，但是使用 run-java 可以预先运行一次：</p>
         <pre class="brush:shell; toolbar: true; auto-links: false;">RUN_JAVA_DRY=1 $TIMEMACHINE_HOME/bin/run-java -cp "$HOME/apps/my-app/lib/*" groovy.ui.GroovyMain test.groovy</pre>
         <p> 你只需在命令提示行中运行上面一整行代码即可。它将输出完整的附带所有选项和参数的java命令。</p>
         <p>run-script还包含很多其它的选项，你可以通过查看其注释了解。当前的脚本能够在任何的Linux bash和Windows Cygwin中运行。</p>
         <p><b>在开发中通过Maven使用 run-java</b></p>
         <p>根据上面提到的示例，假设项目发布结构如下：</p>
         <pre><code>$TIMEMACHINE_HOME
         +- bin/run-java
         +- lib/*.jar</code></pre>
         <p> 但是在开发过程中目录会是怎样呢？一个常见的用例便是：你希望能够运行target/classes下最新编译的代码而不是将整个项目打包或者发布。你同样可以在此种情况下使用 run-java 。首先，简单的将 bin/run-java 添加进你的项目，然后运行</p>
         <pre class="brush:shell; toolbar: true; auto-links: false;">mvn compile dependency:copy-dependencies</pre>
         <p> 将会在target/dependency下生成所有的jar文件。就只需要做这些。run-java将自动的检测这些目录，并为你的main class创建正确的classpath。</p>
         <p>如果你使用Eclipse来开发，那么你的target/classes目录将总是在更新的，run-java便能成为你项目开发中的瑰宝。</p>
         <p><b>获取 run-java 包装脚本</b></p>
         <pre class="brush:shell; toolbar: true; auto-links: false;">#!/usr/bin/env bash
         #
         # Copyright 2012 Zemian Deng
         #
         # Licensed under the Apache License, Version 2.0 (the "License");
         # you may not use this file except in compliance with the License.
         # You may obtain a copy of the License at
         #
         #    http://www.apache.org/licenses/LICENSE-2.0
         #
         # Unless required by applicable law or agreed to in writing, software
         # distributed under the License is distributed on an "AS IS" BASIS,
         # WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
         # See the License for the specific language governing permissions and
         # limitations under the License.

         # A wrapper script that run any Java6 application in unix/cygwin env.
         #
         # This script is assumed to be located in an application's "bin" directory. It will
         # auto resolve any symbolic link and always run in relative to this application
         # directory (which is one parent up from the script.) Therefore, this script can be
         # run any where in the file system and it will still reference this application
         # directory.
         #
         # This script will by default auto setup a Java classpath that picks up any "config"
         # and "lib" directories under the application directory. It also will also add a
         # any typical Maven project output directories such as "target/test-classes",
         # "target/classes", and "target/dependency" into classpath. This can be disable by
         # setting RUN_JAVA_NO_PARSE=1.
         #
         # If the "Default parameters" section bellow doesn't match to user's env, then user
         # may override these variables in their terminal session or preset them in shell's
         # profile startup script. The values of all path should be in cygwin/unix path,
         # and this script will auto convert them into Windows path where is needed.
         #
         # User may customize the Java classpath by setting RUN_JAVA_CP, which will prefix to existing
         # classpath, or use the "-cp" option, which will postfix to existing classpath.
         #
         # Usage:
         #   run-java [java_opts] &lt;java_main_class&gt; [-cp /more/classpath] [-Dsysprop=value]
         #
         # Example:
         #   run-java example.Hello
         #   run-java example.Hello -Dname=World
         #   run-java org.junit.runner.JUnitCore example.HelloTest -cp "C:\apps\lib\junit4.8.2\*"
         #
         # Created by: Zemian Deng 03/09/2012

         # This run script dir (resolve to absolute path)
         SCRIPT_DIR=$(cd $(dirname $0) &amp;&amp; pwd)    # This dir is where this script live.
         APP_DIR=$(cd $SCRIPT_DIR/.. &amp;&amp; pwd)      # Assume the application dir is one level up from script dir.

         # Default parameters
         JAVA_HOME=${JAVA_HOME:=/apps/jdk}        # This is the home directory of Java development kit.
         RUN_JAVA_CP=${RUN_JAVA_CP:=$CLASSPATH}     # A classpath prefix before -classpath option, default to $CLASSPATH
         RUN_JAVA_OPTS=${RUN_JAVA_OPTS:=}           # Java options (-Xmx512m -XX:MaxPermSize=128m etc)
         RUN_JAVA_DEBUG=${RUN_JAVA_DEBUG:=}         # If not empty, print the full java command line before executing it.
         RUN_JAVA_NO_PARSE=${RUN_JAVA_NO_PARSE:=}   # If not empty, skip the auto parsing of -D and -cp options from script arguments.
         RUN_JAVA_NO_AUTOCP=${RUN_JAVA_NO_AUTOCP:=} # If not empty, do not auto setup Java classpath
         RUN_JAVA_DRY=${RUN_JAVA_DRY:=}             # If not empty, do not exec Java command, but just print

         # OS specific support.  $var _must_ be set to either true or false.
         CYGWIN=false;
         case "`uname`" in
         CYGWIN*) CYGWIN=true ;;
         esac

         # Define where is the java executable is
         JAVA_CMD=java
         if [ -d "$JAVA_HOME" ]; then
         JAVA_CMD="$JAVA_HOME/bin/java"
         fi

         # Auto setup applciation's Java Classpath (only if they exists)
         if [ -z "$RUN_JAVA_NO_AUTOCP" ]; then
         if $CYGWIN; then
         # Provide Windows directory conversion
         JAVA_HOME_WIN=$(cygpath -aw "$JAVA_HOME")
         APP_DIR_WIN=$(cygpath -aw "$APP_DIR")

         if [ -d "$APP_DIR_WIN\config" ]; then RUN_JAVA_CP="$RUN_JAVA_CP;$APP_DIR_WIN\config" ; fi
         if [ -d "$APP_DIR_WIN\target\test-classes" ]; then RUN_JAVA_CP="$RUN_JAVA_CP;$APP_DIR_WIN\target\test-classes" ; fi
         if [ -d "$APP_DIR_WIN\target\classes" ]; then RUN_JAVA_CP="$RUN_JAVA_CP;$APP_DIR_WIN\target\classes" ; fi
         if [ -d "$APP_DIR_WIN\target\dependency" ]; then RUN_JAVA_CP="$RUN_JAVA_CP;$APP_DIR_WIN\target\dependency\*" ; fi
         if [ -d "$APP_DIR_WIN\lib" ]; then RUN_JAVA_CP="$RUN_JAVA_CP;$APP_DIR_WIN\lib\*" ; fi
         else
         if [ -d "$APP_DIR/config" ]; then RUN_JAVA_CP="$RUN_JAVA_CP:$APP_DIR/config" ; fi
         if [ -d "$APP_DIR/target/test-classes" ]; then RUN_JAVA_CP="$RUN_JAVA_CP:$APP_DIR/target/test-classes" ; fi
         if [ -d "$APP_DIR/target/classes" ]; then RUN_JAVA_CP="$RUN_JAVA_CP:$APP_DIR/target/classes" ; fi
         if [ -d "$APP_DIR/target/dependency" ]; then RUN_JAVA_CP="$RUN_JAVA_CP:$APP_DIR/target/dependency/*" ; fi
         if [ -d "$APP_DIR/lib" ]; then RUN_JAVA_CP="$RUN_JAVA_CP:$APP_DIR/lib/*" ; fi
         fi
         fi

         # Parse addition "-cp" and "-D" after the Java main class from script arguments
         #   This is done for convenient sake so users do not have to export RUN_JAVA_CP and RUN_JAVA_OPTS
         #   saparately, but now they can pass into end of this run-java script instead.
         #   This can be disable by setting RUN_JAVA_NO_PARSE=1.
         if [ -z "$RUN_JAVA_NO_PARSE" ]; then
         # Prepare variables for parsing
         FOUND_CP=
         declare -a NEW_ARGS
         IDX=0

         # Parse all arguments and look for "-cp" and "-D"
         for ARG in "$@"; do
         if [[ -n $FOUND_CP ]]; then
         if [ "$OS" = "Windows_NT" ]; then
         # Can't use cygpath here, because cygpath will auto expand "*", which we do not
         # want. User will just have to use OS path when specifying "-cp" option.
         #ARG=$(cygpath -w -a $ARG)
         RUN_JAVA_CP="$RUN_JAVA_CP;$ARG"
         else
         RUN_JAVA_CP="$RUN_JAVA_CP:$ARG"
         fi
         FOUND_CP=
         else
         case $ARG in
         '-cp')
         FOUND_CP=1
         ;;
         '-D'*)
         RUN_JAVA_OPTS="$RUN_JAVA_OPTS $ARG"
         ;;
         *)
         NEW_ARGS[$IDX]="$ARG"
         let IDX=$IDX+1
         ;;
         esac
         fi
         done

         # Display full Java command.
         if [ -n "$RUN_JAVA_DEBUG" ] || [ -n "$RUN_JAVA_DRY" ]; then
         echo "$JAVA_CMD" $RUN_JAVA_OPTS -cp "$RUN_JAVA_CP" "${NEW_ARGS[@]}"
         fi

         # Run Java Main class using parsed variables
         if [ -z "$RUN_JAVA_DRY" ]; then
         "$JAVA_CMD" $RUN_JAVA_OPTS -cp "$RUN_JAVA_CP" "${NEW_ARGS[@]}"
         fi
         else
         # Display full Java command.
         if [ -n "$RUN_JAVA_DEBUG" ] || [ -n "$RUN_JAVA_DRY" ]; then
         echo "$JAVA_CMD" $RUN_JAVA_OPTS -cp "$RUN_JAVA_CP" "$@"
         fi

         # Run Java Main class
         if [ -z "$RUN_JAVA_DRY" ]; then
         "$JAVA_CMD" $RUN_JAVA_OPTS -cp "$RUN_JAVA_CP" "$@"
         fi
         fi</pre>
         <p> </p>
         <a target="_blank" href="http://saltnlight5.blogspot.tw/2012/08/a-better-java-shell-script-wrapper.html" rel="nofollow">原文链接 </a>/
         <a target="_blank" href="http://www.oschina.net" rel="nofollow">OSChina.NET 原创翻译</a>
         <br>
         * commentCount : 6
         * favorite : false
         * href : https://www.oschina.net/question/89964_64993
         * id : 64993
         * pubDate : 2012-08-14 17:54:33
         * tags : ["Java","OSCHINA原创翻译"]
         * title : 一个更好Java Shell 脚本包装
         * viewCount : 4994
         */

        private String author;
        private int authorId;
        private String authorPortrait;
        private String body;
        private int commentCount;
        private boolean favorite;
        private String href;
        private int id;
        private String pubDate;
        private String title;
        private int viewCount;
        private List<String> tags;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getAuthorId() {
            return authorId;
        }

        public void setAuthorId(int authorId) {
            this.authorId = authorId;
        }

        public String getAuthorPortrait() {
            return authorPortrait;
        }

        public void setAuthorPortrait(String authorPortrait) {
            this.authorPortrait = authorPortrait;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public boolean isFavorite() {
            return favorite;
        }

        public void setFavorite(boolean favorite) {
            this.favorite = favorite;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getViewCount() {
            return viewCount;
        }

        public void setViewCount(int viewCount) {
            this.viewCount = viewCount;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }
    }
}
