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
        # Emitting write((1 + (2 * 3)))
          # Emitting (1 + (2 * 3))
            # Emitting 1
            movl $1, %edi
          pushl %edi
            # Emitting (2 * 3)
              # Emitting 2
              movl $2, %edi
            pushl %edi
              # Emitting 3
              movl $3, %edi
            movl -8(%ebp), %esi
            addl $4, %esp
            imull %edi, %esi
          movl -4(%ebp), %edi
          addl $4, %esp
          addl %esi, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write(((1 + 2) * 3))
          # Emitting ((1 + 2) * 3)
            # Emitting (1 + 2)
              # Emitting 1
              movl $1, %edi
            pushl %edi
              # Emitting 2
              movl $2, %edi
            movl -4(%ebp), %esi
            addl $4, %esp
            addl %edi, %esi
          pushl %esi
            # Emitting 3
            movl $3, %esi
          movl -4(%ebp), %edi
          addl $4, %esp
          imull %esi, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((1 + (2 * 3)))
          # Emitting (1 + (2 * 3))
            # Emitting 1
            movl $1, %edi
          pushl %edi
            # Emitting (2 * 3)
              # Emitting 2
              movl $2, %edi
            pushl %edi
              # Emitting 3
              movl $3, %edi
            movl -8(%ebp), %esi
            addl $4, %esp
            imull %edi, %esi
          movl -4(%ebp), %edi
          addl $4, %esp
          addl %esi, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((1 + (2 / 3)))
          # Emitting (1 + (2 / 3))
            # Emitting 1
            movl $1, %edi
          pushl %edi
            # Emitting (2 / 3)
              # Emitting 2
              movl $2, %edi
            pushl %edi
              # Emitting 3
              movl $3, %edi
            movl -8(%ebp), %esi
            addl $4, %esp
            movl %esi, %eax
            cltd
            idivl %edi
            movl %eax, %esi
          movl -4(%ebp), %edi
          addl $4, %esp
          addl %esi, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write(((1 + 2) / 3))
          # Emitting ((1 + 2) / 3)
            # Emitting (1 + 2)
              # Emitting 1
              movl $1, %edi
            pushl %edi
              # Emitting 2
              movl $2, %edi
            movl -4(%ebp), %esi
            addl $4, %esp
            addl %edi, %esi
          pushl %esi
            # Emitting 3
            movl $3, %esi
          movl -4(%ebp), %edi
          addl $4, %esp
          movl %edi, %eax
          cltd
          idivl %esi
          movl %eax, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((1 + (2 / 3)))
          # Emitting (1 + (2 / 3))
            # Emitting 1
            movl $1, %edi
          pushl %edi
            # Emitting (2 / 3)
              # Emitting 2
              movl $2, %edi
            pushl %edi
              # Emitting 3
              movl $3, %edi
            movl -8(%ebp), %esi
            addl $4, %esp
            movl %esi, %eax
            cltd
            idivl %edi
            movl %eax, %esi
          movl -4(%ebp), %edi
          addl $4, %esp
          addl %esi, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((1 / (2 + 3)))
          # Emitting (1 / (2 + 3))
            # Emitting 1
            movl $1, %edi
          pushl %edi
            # Emitting (2 + 3)
              # Emitting 2
              movl $2, %edi
            pushl %edi
              # Emitting 3
              movl $3, %edi
            movl -8(%ebp), %esi
            addl $4, %esp
            addl %edi, %esi
          movl -4(%ebp), %edi
          addl $4, %esp
          movl %edi, %eax
          cltd
          idivl %esi
          movl %eax, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
