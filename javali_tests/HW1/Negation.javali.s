  # Emitting class Main {...}
    # Emitting void main(...) {...}
.LC0:
    .string "%d"
.LC1:
    .string "\n"
    .globl _main

_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting A = 1
          # Emitting A
          addl $-4, %esp
          # Emitting 1
          movl $1, %edi
        movl %edi, -40(%ebp)
        # Emitting B = 1
          # Emitting B
          addl $-4, %esp
          # Emitting 1
          movl $1, %edi
        movl %edi, -44(%ebp)
        # Emitting a = (A * -(B))
          # Emitting a
          addl $-4, %esp
          # Emitting (A * -(B))
            # Emitting A
            movl -40(%ebp), %edi
            # Emitting -(B)
              # Emitting B
              movl -44(%ebp), %esi
            negl %esi
          pushl %edi
          pushl %esi
          movl 4(%esp), %edi
          imull 0(%esp), %edi
        movl %edi, -48(%ebp)
        # Emitting b = (-(A) * B)
          # Emitting b
          addl $-4, %esp
          # Emitting (-(A) * B)
            # Emitting -(A)
              # Emitting A
              movl -40(%ebp), %edi
            negl %edi
            # Emitting B
            movl -44(%ebp), %edx
          pushl %edi
          pushl %edx
          movl 4(%esp), %edi
          imull 0(%esp), %edi
        movl %edi, -52(%ebp)
        # Emitting c = -((A + B))
          # Emitting c
          addl $-4, %esp
          # Emitting -((A + B))
            # Emitting (A + B)
              # Emitting A
              movl -40(%ebp), %edi
              # Emitting B
              movl -44(%ebp), %ecx
            pushl %edi
            pushl %ecx
            movl 4(%esp), %edi
            addl 0(%esp), %edi
          negl %edi
        movl %edi, -56(%ebp)
        # Emitting d = -((A * B))
          # Emitting d
          addl $-4, %esp
          # Emitting -((A * B))
            # Emitting (A * B)
              # Emitting A
              movl -40(%ebp), %edi
              # Emitting B
              movl -44(%ebp), %ebx
            pushl %edi
            pushl %ebx
            movl 4(%esp), %edi
            imull 0(%esp), %edi
          negl %edi
        movl %edi, -60(%ebp)
        # Emitting write(a)
          # Emitting a
          movl -48(%ebp), %edi
        pushl %edi
        call _printf
        # Emitting writeln()
        pushl $.LC1
        call _printf
        # Emitting write(b)
          # Emitting b
          movl -52(%ebp), %edi
        pushl %edi
        call _printf
        # Emitting writeln()
        pushl $.LC1
        call _printf
        # Emitting write(c)
          # Emitting c
          movl -56(%ebp), %edi
        pushl %edi
        call _printf
        # Emitting writeln()
        pushl $.LC1
        call _printf
        # Emitting write(d)
          # Emitting d
          movl -60(%ebp), %edi
        pushl %edi
        call _printf
        # Emitting writeln()
        pushl $.LC1
        call _printf
    movl $0, %eax
    leave
    ret
